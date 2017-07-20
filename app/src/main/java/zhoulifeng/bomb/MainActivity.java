package zhoulifeng.bomb;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class MainActivity extends BaseActivity {
    private Button tvResigter;
    private String tag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View view) {
        final Me me = new Me();
        me.setUser_name("Zachary46");
        me.setUser_pwd("111111111111");
        addSubscription(me.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                Toast.makeText(MainActivity.this,"注册成功:" + s,Toast.LENGTH_SHORT).show();
                tag=s;
            }
        }));
    }

    public void delete(View view) {
        Me me = new Me();
        me.setObjectId("dd8e6aff28");
        me.delete(new UpdateListener() {

            @Override
            public void done(BmobException e) {
                if(e==null){
                    Log.i("bmob","成功");
                }else{
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }

    public void update(View view) {
        Me me=new Me();
        me.setUser_pwd("88888888");
        me.update(tag, new UpdateListener() {

                    @Override
                    public void done(BmobException e) {
                        if(e==null){
                            Log.i("bmob","更新成功");
                        }else{
                            Log.i("bmob","更新失败："+e.getMessage()+","+e.getErrorCode());
                        }
                    }
                });
    }

    public void query(View view) {
        BmobQuery<Me> query = new BmobQuery<Me>();
        query.addWhereEqualTo("user_name", "Zachary46");
        query.findObjects(new FindListener<Me>() {

            @Override
            public void done(List<Me> object, BmobException e) {
                if(e==null){
                    if (object.size()>0){
                        Toast.makeText(MainActivity.this,"查询成功:存在这个人" ,Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }

        });
    }
}
