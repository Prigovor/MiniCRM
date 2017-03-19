package com.crm.managers;

import no.vianett.sms.Sms;
import no.vianett.sms.component.SmsTransceiver;
import no.vianett.sms.log.SmsScreenLogger;

/**
 * Created by Bohdan on 25.02.2017.
 */
public class SmsManager
{
    private static final SmsManager instance = new SmsManager();

    public static SmsManager getInstance()
    {
        return instance;
    }

    private SmsManager()
    {

    }

    public void sendSms(String senderNumber, String recipientNumber, String message)
    {
        SmsTransceiver transceiver = SmsTransceiver.getInstance();

        String smsHost = "cpa.vianett.no";
        String smsPort = "31337";
        String smsUsername = "imrahill120@gmail.com";
        String smsPassword = "swzw3";
        transceiver.initialize(smsHost, Integer.parseInt(smsPort), smsUsername, smsPassword, new SmsScreenLogger());

        Sms sms = new Sms();

        sms.setSender(senderNumber);
        sms.setMessage(message);
        sms.setRecipient(recipientNumber);

        transceiver.send(sms);
    }

    public void sendSms(String recipientNumber, String message)
    {
        String number = recipientNumber.replaceAll("\\+", "");

        sendSms("380509442389", number, message);
    }
}
