package me.juanto3.whatssecret;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by jonat on 24/02/2018.
 */

public class ContactListViewModel extends AndroidViewModel {
    private final LiveData<List<Contact>> contactList;

    private AppDatabase appDatabase;

    public ContactListViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

        contactList = appDatabase.contactDao().getAll();
    }

    public LiveData<List<Contact>> getContactList() {
        return contactList;
    }

    public void deleteItem(Contact contact) {
        new deleteAsyncTask(appDatabase).execute(contact);
    }

    private static class deleteAsyncTask extends AsyncTask<Contact, Void, Void> {
        private AppDatabase db;

        deleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final Contact... params) {
            db.contactDao().delete(params[0]);
            return null;
        }
    }
}
