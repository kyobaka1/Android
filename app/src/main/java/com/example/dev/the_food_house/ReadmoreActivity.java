package com.example.dev.the_food_house;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;



import java.io.ByteArrayOutputStream;

import static com.example.dev.the_food_house.R.drawable.gioithieu2;

public class ReadmoreActivity extends AppCompatActivity {
    String name;
    String name1;
    String name2;
    String name3;
    String name4;
    String x="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readmore);


        Intent intent = getIntent();
        //doan nay bat cái put extra (YourValueKey) = "1"

        Bitmap bmp =  BitmapFactory.decodeResource(getResources(),R.drawable.monan);//your image
        ByteArrayOutputStream bYtE = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, bYtE);
        bmp.recycle();
        byte[] byteArray = bYtE.toByteArray();
        String encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
        // Log.e("log",""+encodedImage);







        name1 = intent.getStringExtra("YourValueKey1");
        name2 = intent.getStringExtra("YourValueKey2");
        name3 = intent.getStringExtra("YourValueKey3");
        name4 = intent.getStringExtra("YourValueKey4");
        //Log.e("name","1 :"+name+"2:"+name1);

        if(x.equalsIgnoreCase(name1)) {

            TextView tv=(TextView)findViewById(R.id.txtrm);
            tv.setText("Chương trình Back To School \n   Để tiếp thêm năng lượng đón chào một mùa tựu trường rộn ràng,VietFeeder hân hạnh mang đến cho các bạn học sinh, sinh viên chương trình siêu khuyến mãi ĐI 4 TẶNG 1 chính thức được áp dụng từ ngày 22.8 - 16.9.2018.\n   Với thực đơn hấp dẫn hơn 70 món ăn từ khắp nơi trên thế giới, nhà hàng Hoàng Yến Buffet chắc chắn sẽ mang đến cho các bạn một hành trình ẩm thực độc đáo và thú vị. Bên cạnh đó, phong gian quen thuộc được trau chuốt bằng các chi tiết trang trí gỗ hoa văn sang trọng hứa hẹn sẽ là địa điểm nghỉ chân lý tưởng sau những giờ học căng thẳng hoặc ăn chơi cuối tuần cùng bạn bè.\n  Điều khoản áp dụng:\n  - Miễn phí 1 món ăn cho nhóm 4\n   - Áp dụng tất cả các ngày trong tuần (Không áp dụng T7 – CN tại chi nhánh Vincom)\n   - Chỉ dành cho Học sinh sinh viên (vui lòng mang theo Thẻ HSSV còn hạn).\n   - Không áp dụng vào ngày lễ và đồng thời với những chương trình khuyến mãi khác\n");
            ImageView iv=(ImageView)findViewById(R.id.img);
            iv.setImageResource(R.drawable.gioithieu1);

        }


        if(x.equalsIgnoreCase(name2)) {

            TextView tv=(TextView)findViewById(R.id.txtrm);
            tv.setText("[VietFeeder] RA MẮT MENU “PHỐ NGON ĐÓN HÈ” - TẶNG BIA ZAMKY & TRÁNG MIỆNG MÁT LẠNH\n" +
                    " \n" +
                    "Đón một mùa hè rực rỡ, VietFeeder ra mắt menu mới “Phố Ngon đón hè” với những món ăn hấp dẫn nhất được chế biến qua bàn tay khéo léo của các đầu bếp tài hoa, mang đến cho thực khách những dư vị đặc biệt khi thưởng thức.\n" +
                    "  \n VietFeeder chiêu đãi thực khách với ưu đãi giải nhiệt cực đã:\n" +
                    " \n" +
                    "TẶNG NGAY 01 BIA ZAMKY TRỊ GIÁ 35.000 VNĐ VÀ 01 BÁT CHÈ TRỊ GIÁ 20.000 VNĐ cho tất cả các khách hàng sử dụng món trong menu “VietFeeder đón hè\"\n" +
                    " \n" +
                    "**Điều kiện áp dụng:\n" +
                    " \n" +
                    "- Khách hàng được tặng 1 ly bia Zamky trị giá 35.000 và 1 bát chè bất kỳ trong 6 loại trị giá 20.000 khi sử dụng món trong menu “VietFeeder Đón Hè”.\n" +
                    " \n" +
                    "- Không áp dụng chương trình đối với khách hàng sử dụng món “Cháo đậu đen” trong menu “Phố Ngon Đón Hè”.\n" +
                    " \n" +
                    "- Cho phép áp dụng lũy kế theo số lượng món khách sử dụng trong menu “VietFeeder Đón Hè”.\n" +
                    " \n" +
                    "- Không áp dụng song song với các chương trình ưu đãi khác.\n" +
                    " \n" +
                    "- Khách hàng có thẻ G-People được trừ voucher trong ví, được tích điểm nâng hạng thẻ, không được cộng tiền vào ví.\n" +
                    " \n" +
                    "- Thời gian áp dụng: 15 /04/2018 – 29/05/2018.\n");
            ImageView iv=(ImageView)findViewById(R.id.img);
            iv.setImageResource(R.drawable.gioithieu2);

        }

        if(x.equalsIgnoreCase(name3)) {

            TextView tv=(TextView)findViewById(R.id.txtrm);
            tv.setText("Trong 4 ngày 24-25/4; 30/4 và ngày đầu tiên của năm mới 2018, nhà hàng mang đến 2 thực đơn đặc biệt với mức giá chung 1 triệu đồng/set ăn người lớn (chưa bao gồm VAT).\n Mỗi thực đơn từ 8-10 món sẽ mang đến những trải nghiệm ẩm thực phong phú cho vị giác của thực khách.\n  ");

            ImageView iv=(ImageView)findViewById(R.id.img);
            iv.setImageResource(R.drawable.monan);

        }


        if(x.equalsIgnoreCase(name4)) {

            TextView tv=(TextView)findViewById(R.id.txtrm);
            tv.setText("Nhà Hàng VietFeeder tự hào giới thiệu phong vị Ẩm thực Việt Nam phong phú, với nhiều món ăn mang hơi thở và hương vị riêng biêt từ quê hương mình.\n Hương vị đặc trưng ấy được kiến tạo từ bàn tay của những người đầu bếp tài hoa và đầy kinh nghiệm mà chúng tôi may mắn được cùng hợp tác, hứa hẹn sẽ khiến mỗi thực khách đến nhà hàng đều ra về với sự hài lòng trọn vẹn.\n Toạ lạc đối diện Chợ Bến Thành đông đúc và nhộn nhịp, nơi rất nhiều du khách từ khắp nơi trên thế giới thường xuyên đến thăm thú và mua sắm, Nhà Hàng Việt như một điểm hẹn gần gũi cho những người bạn quốc tế, cùng đến và thưởng thức nhiều món ăn đặc trưng từ các vùng miền trải dọc mảnh đất hình chữ S này, từ con người Việt Nam mộc mạc nhưng đầy tài hoa. Hoặc giả bạn là người Việt, cũng hãy đến để thử, để trải nghiệm những món ăn dân tộc theo một cách khác, chân thật nhưng mới mẻ hơn.Nhà hàng VietFeeder mang đến những món ăn với sự chuẩn bị kĩ lưõng và đầy tâm huyết, từ khâu tuyển chọn nguyên liệu và gia vị đến trang trí và bày biện món ăn, với một mục đích chính là đem Ẩm thực Việt Nam thật nhất, trọn vẹn nhất, đến với tất cả thực khách của chúng tôi.");
            ImageView iv=(ImageView)findViewById(R.id.img);
            iv.setImageResource(R.drawable.monan1);

        }





    }
}
