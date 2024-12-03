package com.example.basicclassexample

import android.os.Parcel
import android.os.Parcelable

class TestClass() : Parcelable {

    var data10: Int = 0
    var data20: String? = null

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(data10)
        dest?.writeString(data20)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TestClass> {
        override fun createFromParcel(parcel: Parcel): TestClass {
            val test = TestClass()
            test.data10 = parcel.readInt()
            test.data20 = parcel.readString()

            return test
        }

        override fun newArray(size: Int): Array<TestClass?> {
            return arrayOfNulls(size)
        }
    }

}