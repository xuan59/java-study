package com.concurrency.publish;

import com.concurrency.annoations.NotThreadSafe;
import com.concurrency.annoations.Recommend;

@NotThreadSafe
@Recommend
public class Escape {
    private int thisCanBeEscape = 0;
    public Escape(){
        new InnerClass();
    }
    private class InnerClass{
        public InnerClass(){
            System.out.println(Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
