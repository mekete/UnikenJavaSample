package com.uniken.sampleapp.utils;


import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.uniken.rdna.RDNA;
import com.uniken.sampleapp.BuildConfig;
import com.uniken.sampleapp.manager.SettingsManager;

import java.util.Date;
import java.util.HashMap;

public class RDNAAPIClient {

    static private RDNAAPIClient apiClient;
    static private Activity activity;
    public static RDNA rdna;

    String authGatewayHNIP = "35.154.72.21";
    int authGatewayPORT = 4443;
    String cipherSpecs;
    //    String cipherSalt = BuildConfig.APPLICATION_ID;
    RDNA.RDNAProxySettings proxySettings;
    RDNA.RDNASSLCertificate sslCertificate;
    String[] dnsServer;
    RDNA.RDNALoggingLevel loggingLevel = RDNA.RDNALoggingLevel.RDNA_LOG_VERBOSE;
    Object appCtx;
    String agentInfo = "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";// "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";
    final String userNameOnServer = "test_test";
    String encryptedString = "";


    final int privacyScope = RDNA.RDNAPrivacyScope.RDNA_PRIVACY_SCOPE_USER.intValue;
    final String cipherSpec = "AES/256/CFB/PKCS7Padding";
    final byte[] cipherSalt = null;// "MyCipherSalt".getBytes();


    public void encryptData(final RDNAAPIClient instance, final String someDataToEncrypt) {

        RDNA.RDNAStatus<byte[]> rdnaStatus = instance.rdna.encryptDataPacket(privacyScope, cipherSpec, cipherSalt, someDataToEncrypt.getBytes());
        if (rdnaStatus.result != null) {
            encryptedString = new String(rdnaStatus.result);
            Log.e(TAG, "AAA encryptData: ::" +
                    "\noriginal :::" + someDataToEncrypt +
                    "\n encryptedString:::: " + encryptedString);
            decryptData(RDNAAPIClient.this, rdnaStatus.result);
        } else {
            Log.e(TAG, "\n\n AAA encryptData result: is NULL ");

        }
        Log.e(TAG, "\n\n AAAA encryptDecrypt result: " + rdnaStatus.errorObj.getErrorString());

    }


    private void decryptData(final RDNAAPIClient instance, final byte[] cipheredTextByte) {

        RDNA.RDNAStatus<byte[]> rdnaStatus = instance.rdna.decryptDataPacket(privacyScope, cipherSpec, cipherSalt, cipheredTextByte);

        if (rdnaStatus.result != null) {
            encryptedString = new String(rdnaStatus.result);
            Log.e(TAG,
                    "BBBB \n decryptData rdnaStatus.result:::: " + rdnaStatus.result +
                            "BBBB \n encryptedString:::: " + encryptedString +
                            "\n restored:::: " + rdnaStatus.result
            );
        } else {
            Log.e(TAG, "\n\n BBB decryptData result: is NULL ");

        }
    }

    private RDNAAPIClient(Activity activity) {
        this.activity = activity;
        rdna = RDNA.getInstance();
        //

        RDNA.RDNAError error = rdna.Initialize(
                agentInfo,
                rdnaCallbacks,
                authGatewayHNIP,
                authGatewayPORT,
                cipherSpecs,
                null,//cipherSalt,
                proxySettings,
                sslCertificate,
                dnsServer,
                loggingLevel,
                appCtx);

        Log.e(TAG, "\nCOOOL\nRDNAAPIClient: " +
                "\n getErrorString : " + error.getLongErrorCode() +
                "\n getErrorString : " + error.getShortErrorCode() +
                "\n getErrorString : " + error.getErrorString()
        );
    }

    public static RDNAAPIClient getInstance(Activity activity) {
        if (apiClient == null) {
            apiClient = new RDNAAPIClient(activity);
        }
        RDNA.RDNAHTTPCallbacks httpCallbacks = apiClient.httpCallbacks;
        return apiClient;
    }

    private static final String TAG = "RDNAAPIClient";

    RDNA.RDNACallbacks rdnaCallbacks = new RDNA.RDNACallbacks() {
        @Override
        public Context getDeviceContext() {
            Log.e(TAG, "\ngetDeviceContext: " + " >>> Time: " + new Date());
            return activity;
        }

        @Override
        public RDNA.RDNASecurityServiceConfiguration getSecurityServiceConfiguration() {
            Log.e(TAG, "\ngetSecurityServiceConfiguration: " + "");
            return null;
        }

        @Override
        public String getDeviceToken() {
            Log.e(TAG, "\ngetDeviceToken: " + "");
            return null;
        }

        @Override
        public int onGetNotifications(RDNA.RDNAStatusGetNotifications rdnaStatusGetNotifications) {
            Log.e(TAG, "\nonGetNotifications: " + "\nrdnaStatusGetNotifications: " + rdnaStatusGetNotifications);
            return 0;
        }

        @Override
        public int onUpdateNotification(RDNA.RDNAStatusUpdateNotification rdnaStatusUpdateNotification) {
            Log.e(TAG, "\nonUpdateNotification: " + "\nrdnaStatusUpdateNotification: " + rdnaStatusUpdateNotification);
            return 0;
        }

        @Override
        public int onTerminate(RDNA.RDNAStatusTerminate rdnaStatusTerminate) {
            Log.e(TAG, "\nonTerminate: " + "\nrdnaStatusTerminate: " + rdnaStatusTerminate);
            return 0;
        }

        @Override
        public int onPauseRuntime(RDNA.RDNAStatusPause rdnaStatusPause) {
            Log.e(TAG, "\nonPauseRuntime: " + "\nrdnaStatusPause: " + rdnaStatusPause);
            return 0;
        }

        @Override
        public int onResumeRuntime(RDNA.RDNAStatusResume rdnaStatusResume) {
            Log.e(TAG, "\nonResumeRuntime: " + "\nrdnaStatusResume: " + rdnaStatusResume);
            return 0;
        }

        @Override
        public int onConfigReceived(RDNA.RDNAStatusGetConfig rdnaStatusGetConfig) {
            Log.e(TAG, "\nonConfigReceived: " + "\nrdnaStatusGetConfig: " + rdnaStatusGetConfig);
            return 0;
        }

        @Override
        public int onGetAllChallengeStatus(RDNA.RDNAStatusGetAllChallenges rdnaStatusGetAllChallenges) {
            Log.e(TAG, "\nonGetAllChallengeStatus: " + "\nrdnaStatusGetAllChallenges: " + rdnaStatusGetAllChallenges);
            return 0;
        }

        @Override
        public int onGetPostLoginChallenges(RDNA.RDNAStatusGetPostLoginChallenges rdnaStatusGetPostLoginChallenges) {
            Log.e(TAG, "\nonGetPostLoginChallenges: " + "\nrdnaStatusGetPostLoginChallenges: " + rdnaStatusGetPostLoginChallenges);
            return 0;
        }

        @Override
        public int onLogOff(RDNA.RDNAStatusLogOff rdnaStatusLogOff) {
            Log.e(TAG, "\nonLogOff: " + "\nrdnaStatusLogOff: " + rdnaStatusLogOff);
            return 0;
        }

        @Override
        public RDNA.RDNAIWACreds getCredentials(String s) {
            Log.e(TAG, "\ngetCredentials: " + "\ns: " + s);
            return null;
        }

        @Override
        public int onGetRegistredDeviceDetails(RDNA.RDNAStatusGetRegisteredDeviceDetails rdnaStatusGetRegisteredDeviceDetails) {
            Log.e(TAG, "\nonGetRegistredDeviceDetails: " + "\nrdnaStatusGetRegisteredDeviceDetails: " + rdnaStatusGetRegisteredDeviceDetails);
            return 0;
        }

        @Override
        public int onUpdateDeviceDetails(RDNA.RDNAStatusUpdateDeviceDetails rdnaStatusUpdateDeviceDetails) {
            Log.e(TAG, "\nonUpdateDeviceDetails: " + "\nrdnaStatusUpdateDeviceDetails: " + rdnaStatusUpdateDeviceDetails);
            return 0;
        }

        @Override
        public int onGetNotificationsHistory(RDNA.RDNAStatusGetNotificationHistory rdnaStatusGetNotificationHistory) {
            Log.e(TAG, "\nonGetNotificationsHistory: " + "\nrdnaStatusGetNotificationHistory: " + rdnaStatusGetNotificationHistory);
            return 0;
        }

        @Override
        public int onSessionTimeout(String s) {
            Log.e(TAG, "\nonSessionTimeout: " + "\ns: " + s);
            return 0;
        }

        @Override
        public int onSdkLogPrintRequest(RDNA.RDNALoggingLevel rdnaLoggingLevel, String s) {
            Log.e(TAG, "\nonSdkLogPrintRequest: " + "\nrdnaLoggingLevel: " + rdnaLoggingLevel + "\ns : " + s);
            return 0;
        }

        @Override
        public boolean permissionRequired(String[] strings) {
            Log.e(TAG, "\npermissionRequired: " + "\nstrings: " + strings);
            return false;
        }

        @Override
        public void onInitializeError(RDNA.RDNAError rdnaError) {
            Log.e(TAG, "\nonInitializeError: " + "\nrdnaError: " + rdnaError);

        }

        @Override
        public void onInitializeProgress(RDNA.RDNAInitProgressStatus rdnaInitProgressStatus) {
            Log.e(TAG, "\nonInitializeProgress: " + "\nrdnaInitProgressStatus: " + rdnaInitProgressStatus);

        }

        @Override
        public void getUser(String[] strings, String s, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {
            Log.e(TAG, "\nAAAAAAAA getUser: ");
            rdna.setUser(userNameOnServer);//test_test
        }

        @Override
        public void getActivationCode(String s, String s1, int i, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {
            Log.e(TAG, "\ngetActivationCode: " + "\ns: " + s + "\ni: " + i + "\nrdnaChallengeResponse: " + rdnaChallengeResponse + "\nrdnaError: " + rdnaError);
            if (s.equals("my_user_name_1")) {
                //no need. The key provided will be associated with one user only
            }
            Log.e(TAG, "\n Saved ActivationCode: " + SettingsManager.getActivationCode());

            rdna.setActivationCode(SettingsManager.getActivationCode());

        }

        @Override
        public void getPassword(String s, RDNA.RDNAChallengeOpMode rdnaChallengeOpMode, int i, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {
            Log.e(TAG, "\ngetPassword: " + "\ns: " + s + "\ni: " + i + "\nrdnaChallengeResponse: " + rdnaChallengeResponse + "\nrdnaError: " + rdnaError);

        }

        @Override
        public void getDeviceName(String s, String s1, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {
            Log.e(TAG, "\ngetDeviceName: " + "\ns: " + s + "\ns1: " + s1 + "\nrdnaChallengeResponse: " + rdnaChallengeResponse + "\nrdnaError: " + rdnaError);

        }

        @Override
        public void getAccessCode(String s, String s1, int i, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {
            Log.e(TAG, "\ngetAccessCode: " + "\ns: " + s + "\ns1: " + s1 + "\nrdnaChallengeResponse: " + rdnaChallengeResponse + "\nrdnaError: " + rdnaError);
            Log.e(TAG, "\n Saved AccessCode : " + SettingsManager.getAccessCode());
            rdna.setAccessCode(SettingsManager.getAccessCode());
        }

        @Override
        public void addNewDeviceOptions(String s, String[] strings, HashMap<String, String> hashMap) {
            Log.e(TAG, "\naddNewDeviceOptions: " + "\ns: " + s + "\nstrings: " + strings + "\nhashMap: " + hashMap);
        }

        @Override
        public void onUserLoggedIn(String s, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {
            Log.e(TAG, "\n onUserLoggedIn: " + "\ns: " + s + "\nrdnaChallengeResponse: " + rdnaChallengeResponse + "\nrdnaError: " + rdnaError);
            encryptData(RDNAAPIClient.this, "Here is my message");
        }

        @Override
        public void onTOTPRegistrationStatus(RDNA.RDNAError rdnaError) {
            Log.e(TAG, "\nonTOTPRegistrationStatus: " + "\nrdnaError: " + rdnaError);

        }

        @Override
        public void onTOTPGenerated(String s, String s1, int i, RDNA.RDNAError rdnaError) {
            Log.e(TAG, "\nonTOTPGenerated: " + "\nrdnaError: " + rdnaError);

        }

        @Override
        public void getTOTPPassword(String s, int i, int i1, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {
            Log.e(TAG, "\ngetTOTPPassword: " + "\nrdnaError: " + rdnaError);

        }

        @Override
        public void hideLoader() {

        }

        @Override
        public void showLoader() {

        }

        @Override
        public void activateUserOptions(String s, String[] strings, HashMap<String, String> hashMap) {

        }

        @Override
        public void onUserLoggedOff(RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {

        }

        @Override
        public void onInitialized(RDNA.RDNAChallengeResponse rdnaChallengeResponse) {

        }

        @Override
        public void onLoginIdUpdateStatus(String s, RDNA.RDNARequestStatus rdnaRequestStatus, RDNA.RDNAError rdnaError) {

        }

        @Override
        public void getLoginId() {

        }

        @Override
        public void onCredentialsAvailableForUpdate(String s, String[] strings, RDNA.RDNAError rdnaError) {

        }

        @Override
        public void onUpdateCredentialResponse(String s, String s1, RDNA.RDNARequestStatus rdnaRequestStatus, RDNA.RDNAError rdnaError) {

        }

        @Override
        public void onHandleCustomChallenge(String s, String s1, RDNA.RDNARequestStatus rdnaRequestStatus, RDNA.RDNAError rdnaError) {

        }

        @Override
        public void onForgotLoginIDStatus(RDNA.RDNARequestStatus rdnaRequestStatus, RDNA.RDNAError rdnaError) {

        }

        @Override
        public Activity getCurrentActivity() {
            return activity;
        }

        @Override
        public void onUserConsentThreats(RDNA.RDNAThreat[] rdnaThreats) {

        }

        @Override
        public void onTerminateWithThreats(RDNA.RDNAThreat[] rdnaThreats) {

        }

        @Override
        public void getSecretAnswer(String s, RDNA.RDNAChallengeOpMode rdnaChallengeOpMode, int i, RDNA.RDNASecretQuestionAnswer rdnaSecretQuestionAnswer, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {

        }

        @Override
        public void onSelectSecretQuestionAnswer(String s, RDNA.RDNAChallengeOpMode rdnaChallengeOpMode, String[][] strings, int i, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {

        }

        @Override
        public void onDeviceAuthManagementStatus(String s, boolean b, RDNA.RDNALDACapabilities rdnaldaCapabilities, RDNA.RDNAError rdnaError) {

        }

        @Override
        public void onAccessTokenRefreshed(String s, RDNA.RDNARequestStatus rdnaRequestStatus, RDNA.RDNAError rdnaError) {

        }
    };

    public RDNA.RDNAHTTPCallbacks httpCallbacks = new RDNA.RDNAHTTPCallbacks() {
        @Override
        public int onHttpResponse(RDNA.RDNAHTTPStatus httpStatus) {
            Log.e(TAG, "\n\nonHttpResponse URL: " + httpStatus.getRequest().url);
            //encryptData( RDNAAPIClient.this,  "someDataToEncrypt");
            return 0;
        }
    };


}
