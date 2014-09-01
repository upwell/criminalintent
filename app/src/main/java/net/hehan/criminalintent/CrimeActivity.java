package net.hehan.criminalintent;

import android.app.Fragment;

import java.util.UUID;


public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID crimeID = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        return CrimeFragment.createInstance(crimeID);
    }
}
