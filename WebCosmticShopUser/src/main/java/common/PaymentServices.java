package common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import org.json.JSONObject;

import com.paypal.api.payments.*;
import com.paypal.base.rest.*;

public class PaymentServices {

   



    public String authorizePayment(OrderDetail orderDetail)
            throws PayPalRESTException {

        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(orderDetail);

        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        Payment approvedPayment = requestPayment.create(apiContext);

        return getApprovalLink(approvedPayment);

    }

    private Payer getPayerInformation() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("William")
                .setLastName("Peterson")
                .setEmail("william.peterson@company.com");

        payer.setPayerInfo(payerInfo);

        return payer;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8081/WebCosmticShopUser/cancel.jsp");
        redirectUrls.setReturnUrl("http://localhost:8081/WebCosmticShopUser/review_payment");

        return redirectUrls;
    }

    private List<Transaction> getTransactionInformation(OrderDetail orderDetail) {
        // Details details = new Details();
        // details.setShipping(orderDetail.getShipping());
        // details.setSubtotal(orderDetail.getSubtotal());
        // details.setTax(orderDetail.getTax());
        String total = null;
        try {
            total = convertVNDToUSD(orderDetail.getTotal());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(total);
        // amount.setDetails(details);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        // transaction.setDescription(orderDetail.getProductName());

        // ItemList itemList = new ItemList();
        // List<Item> items = new ArrayList<>();

        // Item item = new Item();
        // item.setCurrency("USD");
        // item.setName(orderDetail.getProductName());
        // item.setPrice(orderDetail.getSubtotal());
        // item.setTax(orderDetail.getTax());
        // item.setQuantity("1");
        //
        // items.add(item);
        // itemList.setItems(items);
        // transaction.setItemList(itemList);

        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);

        return listTransaction;
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;

        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
                break;
            }
        }

        return approvalLink;
    }

    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }

    public Payment executePayment(String paymentId, String payerId)
            throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment payment = new Payment().setId(paymentId);

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        return payment.execute(apiContext, paymentExecution);
    }

    public static String convertVNDToUSD(String amountInVNDStr) throws Exception {
        double amountInVND = Double.parseDouble(amountInVNDStr);

        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject jsonResponse = new JSONObject(response.toString());
        double vndToUsdRate = jsonResponse.getJSONObject("conversion_rates").getDouble("USD");

        double amountInUSD = amountInVND * vndToUsdRate;
        BigDecimal amountInUSDBigDecimal = new BigDecimal(amountInUSD).setScale(2, RoundingMode.HALF_UP);
        return amountInUSDBigDecimal.toString(); // Định dạng tới 2 chữ số thập phân
    }
}
