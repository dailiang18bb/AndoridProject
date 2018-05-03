package com.example.android.cs639springhw7;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getmAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        mRepository.insert(word);
    }
}



/*
If you use LiveData independently from Room, you have to manage updating the data.
 LiveData has no publicly available methods to update the stored data.

If you, the developer, want to update the stored data, you must use MutableLiveData instead of LiveData.
The MutableLiveData class has two public methods that allow you to set the value of a LiveData object,
 setValue(T) and postValue(T). Usually, MutableLiveData is used in the ViewModel,
  and then the ViewModel only exposes immutable LiveData objects to the observers.
 */