package net.hehan.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by han on 14-9-1.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
