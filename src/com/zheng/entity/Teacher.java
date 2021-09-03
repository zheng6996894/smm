package com.zheng.entity;

public class Teacher {
        private int sid;
        private String name;

        public Teacher() {
        }

        public Teacher(int sid, String name) {
            this.sid = sid;
            this.name = name;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

