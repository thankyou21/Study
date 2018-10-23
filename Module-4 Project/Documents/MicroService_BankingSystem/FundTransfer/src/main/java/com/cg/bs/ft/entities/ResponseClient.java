package com.cg.bs.ft.entities;

public class ResponseClient 
{
    private String response;

    public ResponseClient(String response) 
    {
        
        this.response = response;
    }

    public ResponseClient() {

        // TODO Auto-generated constructor stub
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return response;
    }
    
}