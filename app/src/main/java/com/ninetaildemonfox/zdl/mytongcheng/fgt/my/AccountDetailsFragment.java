package com.ninetaildemonfox.zdl.mytongcheng.fgt.my;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.aty.AccountDetailsAdp;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseFragment;
import butterknife.BindView;

/**
 * @author NineTailDemonFox
 * @date 2019/9/5 10:48
 * 功能描述：1账本明细  2 账户明细
 * 联系方式：1037438704@qq.com
 */
public class AccountDetailsFragment extends BaseFragment {

    public static AccountDetailsFragment newInstance(String count, String type) {
        AccountDetailsFragment accountDetailsFragment = new AccountDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("count", count);
        bundle.putString("type", type);
        accountDetailsFragment.setArguments(bundle);
        return accountDetailsFragment;
    }

    private AccountDetailsAdp accountDetailsAdp;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_account_details;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        String count = getArguments().getString("count");
        recyclerView.setLayoutManager(new LinearLayoutManager(fgtContext));
        accountDetailsAdp = new AccountDetailsAdp(R.layout.item_account_list_adp);
        recyclerView.setAdapter(accountDetailsAdp);
        accountDetailsAdp.setNewData(list);
    }

}