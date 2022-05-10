package com.doubleclick.marktinhome.Database;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.doubleclick.marktinhome.BaseApplication;
import com.doubleclick.marktinhome.Model.Chat;

import java.util.List;

/**
 * Created By Eslam Ghazy on 12/11/2021
 */
public class ChatReopsitory {

    private ChatDao chatDao;
    private LiveData<List<Chat>> getAllChat;
    private Context mContext;

    public ChatReopsitory(Application application) {
        this.mContext = application;
        ChatDatabase db = ChatDatabase.getInstance(application);
        chatDao = db.EntitiesDAO();
//        getAllChat = chatDao.getAllChat();

    }

    public void Load(String myID, String FriendID) {
        getAllChat = chatDao.getAllChat(myID, FriendID);
    }

    //insert
    public void insert(Chat word) {
        new InsertAsyncTask(chatDao).execute(word);
    }

    //getLastMassage
    public LiveData<Chat> getLastMassage(String id, String myId) {
        return chatDao.getLastMassege(id, myId);
    }

    public LiveData<Chat> getLastRowMessage(String myID, String FriendID) {
        return chatDao.getLastRowMessage(FriendID, myID);
    }

    public List<Chat> getListData(String myID, String FriendID) {
        return chatDao.getList(myID, FriendID);
    }

    //delete
    public void delete(Chat word) {
        new DeleteAsyncTask(chatDao).execute(word);

    }

    //update
    public void update(Chat word) { //done

        new UpdatetAsyncTask(chatDao).execute(word);

    }

    //getAllWords
    public LiveData<List<Chat>> getAllChat() {
        return getAllChat;
    }

    //deleteAllWords
    public void deleteAllChats() {

        new DeleteAllAsyncTask(chatDao).execute();

    }


    private static class InsertAsyncTask extends AsyncTask<Chat, Void, Void> {

        private ChatDao EntitiesDAO;

        public InsertAsyncTask(ChatDao EntitiesDAO) {
            this.EntitiesDAO = EntitiesDAO;
        }

        @Override
        protected Void doInBackground(Chat... chats) {
            EntitiesDAO.insert(chats[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Chat, Void, Void> {

        private ChatDao EntitiesDAO;

        public DeleteAsyncTask(ChatDao EntitiesDAO) {
            this.EntitiesDAO = EntitiesDAO;
        }

        @Override
        protected Void doInBackground(Chat... chats) {
            EntitiesDAO.delete(chats[0]);
            return null;
        }
    }

    private static class UpdatetAsyncTask extends AsyncTask<Chat, Void, Void> {

        private ChatDao EntitiesDAO;

        public UpdatetAsyncTask(ChatDao EntitiesDAO) {
            this.EntitiesDAO = EntitiesDAO;
        }

        @Override
        protected Void doInBackground(Chat... chats) {
            EntitiesDAO.update(chats[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {

        private ChatDao chatDao;

        public DeleteAllAsyncTask(ChatDao chatDao) {
            this.chatDao = chatDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            chatDao.deleteAllData();

            return null;
        }
    }

}
