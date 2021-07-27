package com.nooryoku.uasmoopkasus1;

import android.widget.EditText;

public  interface Validation{

    void input(EditText txt, String s);

    boolean isNotNull();

    boolean checkUsername(String user);

}
