package com.example.tddexample.databinding;
import com.example.tddexample.R;
import com.example.tddexample.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class MainFragmentBindingImpl extends MainFragmentBinding implements com.example.tddexample.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ll_main, 7);
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener etAnotherandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of vm.secondNumber.getValue()
            //         is vm.secondNumber.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etAnother);
            // localize variables for thread safety
            // vm.secondNumber
            com.example.tddexample.util.NonNullMutableLiveData<java.lang.String> vmSecondNumber = null;
            // vm != null
            boolean vmJavaLangObjectNull = false;
            // vm
            com.example.tddexample.ui.main.MainViewModel vm = mVm;
            // vm.secondNumber.getValue()
            java.lang.String vmSecondNumberGetValue = null;
            // vm.secondNumber != null
            boolean vmSecondNumberJavaLangObjectNull = false;



            vmJavaLangObjectNull = (vm) != (null);
            if (vmJavaLangObjectNull) {


                vmSecondNumber = vm.getSecondNumber();

                vmSecondNumberJavaLangObjectNull = (vmSecondNumber) != (null);
                if (vmSecondNumberJavaLangObjectNull) {




                    vmSecondNumber.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener etOriginandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of vm.firstNumber.getValue()
            //         is vm.firstNumber.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etOrigin);
            // localize variables for thread safety
            // vm != null
            boolean vmJavaLangObjectNull = false;
            // vm
            com.example.tddexample.ui.main.MainViewModel vm = mVm;
            // vm.firstNumber
            com.example.tddexample.util.NonNullMutableLiveData<java.lang.String> vmFirstNumber = null;
            // vm.firstNumber != null
            boolean vmFirstNumberJavaLangObjectNull = false;
            // vm.firstNumber.getValue()
            java.lang.String vmFirstNumberGetValue = null;



            vmJavaLangObjectNull = (vm) != (null);
            if (vmJavaLangObjectNull) {


                vmFirstNumber = vm.getFirstNumber();

                vmFirstNumberJavaLangObjectNull = (vmFirstNumber) != (null);
                if (vmFirstNumberJavaLangObjectNull) {




                    vmFirstNumber.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener tvResultandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of vm.message.getValue()
            //         is vm.message.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(tvResult);
            // localize variables for thread safety
            // vm != null
            boolean vmJavaLangObjectNull = false;
            // vm.message.getValue()
            java.lang.String vmMessageGetValue = null;
            // vm
            com.example.tddexample.ui.main.MainViewModel vm = mVm;
            // vm.message
            com.example.tddexample.util.NonNullMutableLiveData<java.lang.String> vmMessage = null;
            // vm.message != null
            boolean vmMessageJavaLangObjectNull = false;



            vmJavaLangObjectNull = (vm) != (null);
            if (vmJavaLangObjectNull) {


                vmMessage = vm.getMessage();

                vmMessageJavaLangObjectNull = (vmMessage) != (null);
                if (vmMessageJavaLangObjectNull) {




                    vmMessage.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public MainFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private MainFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.Button) bindings[3]
            , (android.widget.Button) bindings[4]
            , (android.widget.Button) bindings[2]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[5]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[1]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[7]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[6]
            );
        this.btnMinus.setTag(null);
        this.btnMultiple.setTag(null);
        this.btnPlus.setTag(null);
        this.etAnother.setTag(null);
        this.etOrigin.setTag(null);
        this.main.setTag(null);
        this.tvResult.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new com.example.tddexample.generated.callback.OnClickListener(this, 2);
        mCallback3 = new com.example.tddexample.generated.callback.OnClickListener(this, 3);
        mCallback1 = new com.example.tddexample.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.vm == variableId) {
            setVm((com.example.tddexample.ui.main.MainViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable com.example.tddexample.ui.main.MainViewModel Vm) {
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmSecondNumber((com.example.tddexample.util.NonNullMutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeVmFirstNumber((com.example.tddexample.util.NonNullMutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeVmMessage((com.example.tddexample.util.NonNullMutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVmSecondNumber(com.example.tddexample.util.NonNullMutableLiveData<java.lang.String> VmSecondNumber, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmFirstNumber(com.example.tddexample.util.NonNullMutableLiveData<java.lang.String> VmFirstNumber, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmMessage(com.example.tddexample.util.NonNullMutableLiveData<java.lang.String> VmMessage, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.tddexample.util.NonNullMutableLiveData<java.lang.String> vmSecondNumber = null;
        com.example.tddexample.util.NonNullMutableLiveData<java.lang.String> vmFirstNumber = null;
        com.example.tddexample.util.NonNullMutableLiveData<java.lang.String> vmMessage = null;
        com.example.tddexample.ui.main.MainViewModel vm = mVm;
        java.lang.String vmFirstNumberGetValue = null;
        java.lang.String vmMessageGetValue = null;
        java.lang.String vmSecondNumberGetValue = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (vm != null) {
                        // read vm.secondNumber
                        vmSecondNumber = vm.getSecondNumber();
                    }
                    updateLiveDataRegistration(0, vmSecondNumber);


                    if (vmSecondNumber != null) {
                        // read vm.secondNumber.getValue()
                        vmSecondNumberGetValue = vmSecondNumber.getValue();
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (vm != null) {
                        // read vm.firstNumber
                        vmFirstNumber = vm.getFirstNumber();
                    }
                    updateLiveDataRegistration(1, vmFirstNumber);


                    if (vmFirstNumber != null) {
                        // read vm.firstNumber.getValue()
                        vmFirstNumberGetValue = vmFirstNumber.getValue();
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (vm != null) {
                        // read vm.message
                        vmMessage = vm.getMessage();
                    }
                    updateLiveDataRegistration(2, vmMessage);


                    if (vmMessage != null) {
                        // read vm.message.getValue()
                        vmMessageGetValue = vmMessage.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.btnMinus.setOnClickListener(mCallback2);
            this.btnMultiple.setOnClickListener(mCallback3);
            this.btnPlus.setOnClickListener(mCallback1);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etAnother, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etAnotherandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etOrigin, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etOriginandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.tvResult, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, tvResultandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etAnother, vmSecondNumberGetValue);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etOrigin, vmFirstNumberGetValue);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvResult, vmMessageGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // vm != null
                boolean vmJavaLangObjectNull = false;
                // vm
                com.example.tddexample.ui.main.MainViewModel vm = mVm;



                vmJavaLangObjectNull = (vm) != (null);
                if (vmJavaLangObjectNull) {


                    vm.onClickMinus();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // vm != null
                boolean vmJavaLangObjectNull = false;
                // vm
                com.example.tddexample.ui.main.MainViewModel vm = mVm;



                vmJavaLangObjectNull = (vm) != (null);
                if (vmJavaLangObjectNull) {


                    vm.onClickMultiple();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // vm != null
                boolean vmJavaLangObjectNull = false;
                // vm
                com.example.tddexample.ui.main.MainViewModel vm = mVm;



                vmJavaLangObjectNull = (vm) != (null);
                if (vmJavaLangObjectNull) {


                    vm.onClickPlus();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm.secondNumber
        flag 1 (0x2L): vm.firstNumber
        flag 2 (0x3L): vm.message
        flag 3 (0x4L): vm
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}