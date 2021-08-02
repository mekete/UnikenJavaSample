package com.uniken.sampleapp.utils;

import android.app.Activity;
import android.content.Context;

import com.uniken.rdna.RDNA;

import java.util.HashMap;

class RDNACallbackAdapter implements RDNA.RDNACallbacks {
    @Override
    public Context getDeviceContext() {
        return null;
    }

    @Override
    public RDNA.RDNASecurityServiceConfiguration getSecurityServiceConfiguration() {
        return null;
    }

    @Override
    public String getDeviceToken() {
        return null;
    }

    @Override
    public int onGetNotifications(RDNA.RDNAStatusGetNotifications rdnaStatusGetNotifications) {
        return 0;
    }

    @Override
    public int onUpdateNotification(RDNA.RDNAStatusUpdateNotification rdnaStatusUpdateNotification) {
        return 0;
    }

    @Override
    public int onTerminate(RDNA.RDNAStatusTerminate rdnaStatusTerminate) {
        return 0;
    }

    @Override
    public int onPauseRuntime(RDNA.RDNAStatusPause rdnaStatusPause) {
        return 0;
    }

    @Override
    public int onResumeRuntime(RDNA.RDNAStatusResume rdnaStatusResume) {
        return 0;
    }

    @Override
    public int onConfigReceived(RDNA.RDNAStatusGetConfig rdnaStatusGetConfig) {
        return 0;
    }

    @Override
    public int onGetAllChallengeStatus(RDNA.RDNAStatusGetAllChallenges rdnaStatusGetAllChallenges) {
        return 0;
    }

    @Override
    public int onGetPostLoginChallenges(RDNA.RDNAStatusGetPostLoginChallenges rdnaStatusGetPostLoginChallenges) {
        return 0;
    }

    @Override
    public int onLogOff(RDNA.RDNAStatusLogOff rdnaStatusLogOff) {
        return 0;
    }

    @Override
    public RDNA.RDNAIWACreds getCredentials(String s) {
        return null;
    }

    @Override
    public int onGetRegistredDeviceDetails(RDNA.RDNAStatusGetRegisteredDeviceDetails rdnaStatusGetRegisteredDeviceDetails) {
        return 0;
    }

    @Override
    public int onUpdateDeviceDetails(RDNA.RDNAStatusUpdateDeviceDetails rdnaStatusUpdateDeviceDetails) {
        return 0;
    }

    @Override
    public int onGetNotificationsHistory(RDNA.RDNAStatusGetNotificationHistory rdnaStatusGetNotificationHistory) {
        return 0;
    }

    @Override
    public int onSessionTimeout(String s) {
        return 0;
    }

    @Override
    public int onSdkLogPrintRequest(RDNA.RDNALoggingLevel rdnaLoggingLevel, String s) {
        return 0;
    }

    @Override
    public boolean permissionRequired(String[] strings) {
        return false;
    }

    @Override
    public void onInitializeError(RDNA.RDNAError rdnaError) {

    }

    @Override
    public void onInitializeProgress(RDNA.RDNAInitProgressStatus rdnaInitProgressStatus) {

    }

    @Override
    public void getUser(String[] strings, String s, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {

    }

    @Override
    public void getActivationCode(String s, String s1, int i, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {

    }

    @Override
    public void getPassword(String s, RDNA.RDNAChallengeOpMode rdnaChallengeOpMode, int i, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {

    }

    @Override
    public void getDeviceName(String s, String s1, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {

    }

    @Override
    public void getAccessCode(String s, String s1, int i, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {

    }

    @Override
    public void addNewDeviceOptions(String s, String[] strings, HashMap<String, String> hashMap) {

    }

    @Override
    public void onUserLoggedIn(String s, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {

    }

    @Override
    public void onTOTPRegistrationStatus(RDNA.RDNAError rdnaError) {

    }

    @Override
    public void onTOTPGenerated(String s, String s1, int i, RDNA.RDNAError rdnaError) {

    }

    @Override
    public void getTOTPPassword(String s, int i, int i1, RDNA.RDNAChallengeResponse rdnaChallengeResponse, RDNA.RDNAError rdnaError) {

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
        return null;
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
}
