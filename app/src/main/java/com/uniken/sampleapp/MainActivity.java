package com.uniken.sampleapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import com.uniken.rdna.RDNA;
import com.uniken.sampleapp.manager.SettingsManager;
import com.uniken.sampleapp.utils.RDNAAPIClient;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String BACKEND_URL = "https://35.154.72.21:4443";
    Button mBtnnSaveActivationCode;
    Button mBtnnSaveAccessCode;
    EditText mTxteActivationCode;
    EditText mTxteAccessCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startRdnaClient();

        setContentView(R.layout.activity_register_activation);
        //mMainContent = findViewById(R.id.main_content);
        //mLookUpType = getIntent().getStringExtra(LookUp.FIELD_LOOKUP_TYPE);
        initToolbar();
        initComponents();


    }

    private void startRdnaClient() {
        final RDNAAPIClient instance = RDNAAPIClient.getInstance(MainActivity.this);
        //instance.rdna.setActivationCode()
        final RDNA.RDNAHTTPRequest httpRequest = new RDNA.RDNAHTTPRequest();
        httpRequest.setUrl(BACKEND_URL);

        final RDNA.RDNAStatus<Integer> integerRDNAStatus = instance.rdna.openHttpConnection(httpRequest, instance.httpCallbacks);

        if (integerRDNAStatus != null) {
            final String someDataToEncrypt = "SomeDataToEncrypt";
            //encryptData(instance, someDataToEncrypt);
        }


    }

    private static final String TAG = "MainActivity";
    private static String encryptedString = "";

    public  void encryptData(final RDNAAPIClient instance, final String someDataToEncrypt) {

        int privacyScope = RDNA.RDNAPrivacyScope.RDNA_PRIVACY_SCOPE_USER.intValue;
        String cipherSpec = "AES/256/CFB/PKCS7Padding";
        byte[] cipherSalt = null;// "MyCipherSalt".getBytes();
        byte[] plainTextDataPacket = someDataToEncrypt.getBytes();
        Log.e(TAG, "\n>>>>>>>>\n\n\n\n CCCCC before calling encryptDecrypt errorCode: ");

        RDNA.RDNAStatus<byte[]> rdnaStatus = instance.rdna.encryptDataPacket(privacyScope, cipherSpec, cipherSalt, plainTextDataPacket);
        Log.e(TAG, "\n>>>>>>>>\n\n\n\n CCCCC encryptDecrypt errorCode: " + rdnaStatus.errorCode);
        if (rdnaStatus.result != null) {
            Log.e(TAG, "\n>>>>>>>>\n\nencryptDecrypt result: " + new String(rdnaStatus.result));
            encryptedString = new String(rdnaStatus.result);
        } else {
            Log.e(TAG, "\n>>>>>>>>\n\n encryptDecrypt result: is NULL ");

        }
        Log.e(TAG, "\n>>>>>>>>\n\n encryptDecrypt result: " + rdnaStatus.errorObj.getErrorString());

    }

    interface OnUserLoggedInCallBack{

    }

    private void initComponents() {
        //
        mTxteActivationCode = findViewById(R.id.txte_activation_code);
        mTxteAccessCode = findViewById(R.id.txte_access_code);


        //
        mBtnnSaveActivationCode = findViewById(R.id.btnn_save_activation_code);
        mBtnnSaveAccessCode = findViewById(R.id.btnn_save_access_code);

        mBtnnSaveActivationCode.setOnClickListener(v -> saveActivationCode());
        mBtnnSaveAccessCode.setOnClickListener(v -> saveAccessCode());

    }

    private void saveActivationCode() {
        String activationCode = mTxteActivationCode.getText().toString();
        SettingsManager.setActivationCode(activationCode);
    }

    private void saveAccessCode() {
        String accessCode = mTxteAccessCode.getText().toString();
        SettingsManager.setAccessCode(accessCode);
    }


    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getString(R.string.initialize));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        } else if (id == R.id.action_assignment) {
            mTxteAccessCode.setText(SettingsManager.getAccessCode());
            mTxteActivationCode.setText(SettingsManager.getActivationCode());

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}