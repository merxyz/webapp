package com.example.webapp;

public class CalculusResponse {

    Boolean error;
    Double result;

    public CalculusResponse() {
    }

    public CalculusResponse(Double result) {
        this.error = false;
        this.result = result;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Boolean getError() {
        return error;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CalculusResponse;
    }

    @Override
    public String toString() {
        return "CalculusResponse{error=" + error + ",result=" + result + "}";
    }
}
