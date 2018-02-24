package me.juanto3.whatssecret;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

/**
 * Created by jonat on 24/02/2018.
 */

public class AddContactViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    public AddContactViewModel(Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(this.getApplication());
    }

    public void addContact(final Contact contact) {
        new addAsyncTask(appDatabase).execute(contact);
    }

    private static class addAsyncTask extends AsyncTask<Contact, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final Contact... params) {
            db.contactDao().insertAll(params[0]);
            return null;
        }
    }
}
