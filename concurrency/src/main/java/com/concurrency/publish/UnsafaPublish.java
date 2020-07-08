package com.concurrency.publish;

import com.concurrency.annoations.NotThreadSafe;

/*
* 发布
*
* */
@NotThreadSafe
public class UnsafaPublish {

    private String[] states={"a","b","c"};
    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafaPublish unsafaPublish = new UnsafaPublish();
        System.out.println(unsafaPublish.getStates());
        unsafaPublish.states[0] = "d";
        System.out.println(unsafaPublish.getStates());
    }
}
