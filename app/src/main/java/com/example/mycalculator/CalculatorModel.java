package com.example.mycalculator;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class CalculatorModel implements Parcelable {

    private int firstArg;
    private int secondArg;
    private TextView text;
    private StringBuilder inputStr = new StringBuilder();



    private State state;

    protected CalculatorModel(Parcel in) {
        firstArg = in.readInt();
        secondArg = in.readInt();
    }

    public static final Creator<CalculatorModel> CREATOR = new Creator<CalculatorModel>() {
        @Override
        public CalculatorModel createFromParcel(Parcel in) {
            return new CalculatorModel(in);
        }

        @Override
        public CalculatorModel[] newArray(int size) {
            return new CalculatorModel[size];
        }
    };

    public int getFirstArg() {
        return firstArg;
    }

    public void setFirstArg(int firstArg) {
        this.firstArg = firstArg;
    }

    public int getSecondArg() {
        return secondArg;
    }

    public void setSecondArg(int secondArg) {
        this.secondArg = secondArg;
    }

    public void setText(TextView text) {
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(firstArg);
        dest.writeInt(secondArg);
    }

    private enum State {
        firstArgInput,
        operationSelected,
        secondArgInput,
        resultShow
    }

    public CalculatorModel() {
        state = State.firstArgInput;
    }

    public void onNumPressed(int buttonId) {

        if (state == State.resultShow) {
            state = State.firstArgInput;
            inputStr.setLength(0);
        }

        if (state == State.operationSelected) {
            state = State.secondArgInput;
            inputStr.setLength(0);
        }

        if (inputStr.length() < 9) {
            switch (buttonId) {
                case R.id.zero:
                    if (inputStr.length() != 0) {
                        inputStr.append("0");
                    }
                    break;
                case R.id.one:
                    inputStr.append("1");
                    break;
                case R.id.two:
                    inputStr.append("2");
                    break;
                case R.id.three:
                    inputStr.append("3");
                    break;
                case R.id.four:
                    inputStr.append("4");
                    break;
                case R.id.five:
                    inputStr.append("5");
                    break;
                case R.id.six:
                    inputStr.append("6");
                    break;
                case R.id.seven:
                    inputStr.append("7");
                    break;
                case R.id.eight:
                    inputStr.append("8");
                    break;
                case R.id.nine:
                    inputStr.append("9");
                    break;
            }
        }

    }



    public String getText() {
        StringBuilder str = new StringBuilder();
        switch (state) {
            default:
                return inputStr.toString();
            case operationSelected:
                return str.append(getFirstArg()).append(' ')

                        .toString();
            case secondArgInput:
                return str.append(getFirstArg()).append(' ')

                        .append(' ')
                        .append(inputStr)
                        .toString();
            case resultShow:
                return str.append(getFirstArg()).append(' ')

                        .append(' ')
                        .append(getSecondArg())
                        .append(" = ")
                        .append(inputStr.toString())
                        .toString();
        }
    }



    public void reset() {
        state = State.firstArgInput;
        inputStr.setLength(0);
    }
}
