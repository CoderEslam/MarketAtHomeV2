package com.doubleclick;

import java.lang.System;

/**
 * Created By Eslam Ghazy on 4/22/2022
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/doubleclick/GroupInterface;", "", "allGroups", "", "groups", "Lcom/doubleclick/marktinhome/Model/Group;", "groupData", "Lcom/doubleclick/marktinhome/Model/GroupData;", "myGroups", "app_debug"})
public abstract interface GroupInterface {
    
    public abstract void groupData(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.GroupData groups);
    
    public abstract void myGroups(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.Group groups);
    
    public abstract void allGroups(@org.jetbrains.annotations.NotNull()
    com.doubleclick.marktinhome.Model.Group groups);
}