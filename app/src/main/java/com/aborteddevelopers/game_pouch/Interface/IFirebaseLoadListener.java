package com.aborteddevelopers.game_pouch.Interface;

import com.aborteddevelopers.game_pouch.Model.ItemGroup;

import java.util.List;

public interface IFirebaseLoadListener {

    void onFirebaseLoadSuccess(List<ItemGroup> itemGroupList);
    void onFirebaseLoadFailed(String message);

}
