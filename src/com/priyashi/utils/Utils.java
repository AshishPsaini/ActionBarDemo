package com.priyashi.utils;

import android.app.Activity;
import android.content.Intent;

import com.priyashi.appcompatdemo.R;
public class Utils
{
     private static int sTheme;
     public final static int THEME_DEFAULT = 0;
     public final static int THEME_Base_CompactMenu_Dialog = 1;
     public final static int THEME_Light_DarkActionBar = 2;
     /**
      * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
      */
     public static void changeToTheme(Activity activity, int theme)
     {
          sTheme = theme;
          activity.finish();
activity.startActivity(new Intent(activity, activity.getClass()));
     }
     /** Set
      * 
      *  
      *  
      *  the theme of the activity, according to the configuration. */
     public static void onActivityCreateSetTheme(Activity activity)
     {
          switch (sTheme)
          {
          default:
          case THEME_DEFAULT:
              activity.setTheme(R.style.AppBaseTheme);
              break;
          case THEME_Base_CompactMenu_Dialog:
              activity.setTheme(R.style.TextAppearance_AppCompat_Base_CompactMenu_Dialog);
              break;
          case THEME_Light_DarkActionBar:
              activity.setTheme(R.style.Theme_Base_AppCompat_Light_DarkActionBar);
              break;
          }
     }
     
     
     public static void changeApplicationTheme(int theme) {
    	 sTheme = theme;
     }
}