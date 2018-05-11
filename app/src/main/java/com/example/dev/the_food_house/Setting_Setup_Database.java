package com.example.dev.the_food_house;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Setting_Setup_Database extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private ArrayList<Bao> arBao;
    private Bao TinHot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnv_setting__setup__database);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        writeToFile("Font:1-Background:1-Size:1",this.getBaseContext());
    }
    public void initBao(){
        arBao = new ArrayList<>();
        arBao.add(new Bao("Vụ 4 người bị ngộ độc tử vong ở Quảng Nam: Nghi do rượu có chứa Methanol","https://firebasestorage.googleapis.com/v0/b/testfirebase-888ef.appspot.com/o/bao11.jpg?alt=media&token=61a94b36-db40-41f6-af2a-8827e55e9d95","2018/04/06 12:01:30","Ngày 6/4, tin từ Chi cục Vệ sinh an toàn thực phẩm (Sở Y tế Quảng Nam) cho biết, đơn vị này vừa có báo cáo Kết quả giám sát, xử lí vụ ngộ độc xảy ra tại xã Cà Dy (huyện Nam Giang).\n\n\nNguyên nhân của vụ ngộ độc xảy ra tại xã Cà Dy khiến 4 người tử vong là nghi do rượu có chứa Methanol\nSau hơn 3 tuần nắm bắt sự việc, Chi cục Vệ sinh an toàn thực phẩm kết luận vụ ngộ độc thực phẩm xảy ra tại xã Cà Dy vào ngày 13/3 là nghi do rượu có chứa Methanol. Để đi đến nhận định trên, cơ quan này đã dựa vào dịch tễ học và các kết quả theo dõi, chẩn đoán của khoa Cấp cứu (Trung tâm Y tế huyện Nam Giang). Tuy nhiên, nguyên nhân chính thức phải chờ thêm kết luận điều tra từ phía công an.\n\nTrước đó như Báo Công Thương đã thông tin, vào lúc 10h ngày 13/3, 5 người đàn ông trú thôn Pà Păng (xã Cà Dy) gồm: Hôih Nhân, B Nướch Cheo, A Viết Giang, A Lăng Minh và Bờ Nướch A Chưm mua rượu ở cửa hàng tạp hóa của bà Kphu Nga (cùng thôn) về tổ chức nhậu. Sang ngày hôm sau, 5 người trên đột nhiên hôn mê sâu, da dẻ tím tái, khó thở. Nghi bị ngộ độc rượu nên người nhà nhanh chóng đưa các nạn nhân đến Trung tâm Y tế huyện cấp cứu. Sau đó vận chuyển thẳng xuống Bệnh viện Đa khoa miền núi phía Bắc Quảng Nam và Bệnh viện Đa khoa Đà Nẵng điều trị.\n\nTuy nhiên, 4/5 người đã lần lượt tử vong gồm: A Lăng Minh, Bờ Nướch A Chưm, A Viết Giang và Hôih Nhân. Riêng B Nướch Cheo đã vượt qua cơn nguy kịch nhưng bị chứng mù mắt, nói khó.","https://firebasestorage.googleapis.com/v0/b/testfirebase-888ef.appspot.com/o/bao12.jpg?alt=media&token=0ebd60dc-dca5-4a4f-94ec-b9dbc6338545","100% hộ sản xuất miến đều tham gia ký kết đảm bảo an toàn vệ sinh thực phẩm, cùng hợp tác để bảo vệ thương hiệu miến làng So."));
        arBao.add(new Bao("Thăm làng sản xuất miến lâu đời lớn bậc nhất Việt Nam","https://firebasestorage.googleapis.com/v0/b/testfirebase-888ef.appspot.com/o/bao21.jpg?alt=media&token=868d9b6f-8db3-4b45-9f56-057d2821bb06","2018/04/06 12:01:30","GiadinhNet - Rất hiếm địa phương nào vẫn lưu giữ và phát triển đồng hành cùng với nghề truyền thống như những người dân sản xuất miến ở làng So (Quốc Oai, Hà Nội).\nMiến làng So (xã Cộng Hòa, Quốc Oai, Hà Nội) từ lâu đã trở thành một đặc sản có thương hiểu nổi tiếng khắp mọi miền. Lịch sử của nghề làm miến truyền thống đã được gần 100 năm với sự gìn giữ của nhiều thế hệ người dân làng So.\n\nVới bí quyết riêng được truyền từ đời nay qua đời khác, miến làng So được sản xuất từ củ dong có sợi thơm ngon, dai mềm. Đặc biệt khi nấu lên, sợi miến vẫn giữ được màu trắng trong rất hấp dẫn.\n\nTheo kinh nghiệm của những người sản xuất lâu năm, miến làng So có được sự khác biệt một phần do bí quyết nghề, phần khác là do được thiên nhiên ưu ái khi ban phát cho mảnh đất nơi đây nguồn nước vừa trong vừa ngọt.","https://firebasestorage.googleapis.com/v0/b/testfirebase-888ef.appspot.com/o/bao22.jpg?alt=media&token=c6dc3d2a-747c-4280-a69c-65885acf1e31","Nguyên nhân chủ yếu được các cơ quan chức năng xác định là do ý thức chấp hành quy định của pháp luật về ATTP của các cơ sở sản xuất, cơ sở kinh doanh thực phẩm chưa cao, còn chạy theo lợi nhuận, làm ảnh hưởng tới quyền lợi cũng như sức khỏe người tiêu dùng.\nTại chợ Hội An cơ quan chức năng đã phát hiện 06 mẫu thủy sản khai thác có kháng sinh cấm Chloramphenicol, 5 mẫu chả có Natri benzo\nTại chợ Hội An cơ quan chức năng đã phát hiện 06 mẫu thủy sản khai thác   có kháng sinh cấm Chloramphenicol, 5 mẫu chả có Natri benzo\nPhó Chủ tịch UBND tỉnh Quảng Nam Lê Văn Thanh cho rằng: Trước hết phải đánh giá đúng thực trạng công tác bảo đảm an toàn thực phẩm hiện nay trên địa bàn tỉnh. Qua đó mới đưa ra được những giải pháp quyết liệt, căn cơ có tính bền vững, lâu dài góp phần thực hiện có hiệu quả kế hoạch công tác bảo đảm an toàn thực phẩm trên địa bàn tỉnh năm 2018, tạo được bước chuyển biến mạnh mẽ theo đúng tinh thần của Chỉ thị số 13/CT-TTg ngày 09/5/2016 của Thủ tướng Chính phủ; Chỉ thị số 16/CT-UBND ngày 17/5/2016 của UBND tỉnh Quảng Nam về việc tăng cường trách nhiệm quản lý nhà nước, trách nhiệm của người đứng đầu về an toàn thực phẩm.\n \nThực hiện tháng hành vì ATTP 2018 với chủ đề “Tăng cường trách nhiệm của người sản xuất, kinh doanh thực phẩm”, Quảng Nam đặt ra mục tiêu phấn đấu giảm 5% số vụ ngộ độc thực phẩm tập thể, 80% người sản xuất, chế biến, kinh doanh thực phẩm, người tiêu dùng, người quản lý được cập nhật kiến thức về ATTP; tỷ lệ mẫu vượt mức cho phép dưới 6%... nhằm bảo vệ sức khỏe và quyền lợi cho người tiêu dùng."));
        arBao.add(new Bao("Quảng Nam: Cảnh báo nguy cơ mất an toàn vệ sinh thực phẩm","https://firebasestorage.googleapis.com/v0/b/testfirebase-888ef.appspot.com/o/bao31.jpg?alt=media&token=eb87e7ea-3691-4eda-adba-f378c17608d9","2018/04/06 12:01:30","UBND tỉnh Quảng Nam vừa tổ chức Hội nghị triển khai kế hoạch an toàn thực phẩm và tháng hành động vì ATTP năm 2018 để đánh giá đúng thực trạng công tác bảo đảm ATTP hiện nay trên địa bàn tỉnh.\n \nQuảng Nam hiện có hơn 18.000 cơ sở sản xuất, sơ chế, chế biến, kinh doanh thực phẩm. Trong vài năm gần đây, tại Quảng Nam đã xảy ra hàng chục vụ ngộ độc thực phẩm làm gần 300 người ngộ độc. Trong đó, phần lớn trường hợp ngộ độc là do sử dụng các sản phẩm nông - lâm - thủy sản bị nhiễm độc làm thực phẩm.\n \nTheo Sở Y tế Quảng Nam cho biết thì, năm 2017 ngành Y tế của tỉnh này đã tăng cường triển khai các hoạt động kiểm tra, giám sát đảm bảo ATTP, đặc biệt trong các dịp diễn ra các sự kiện lớn, lễ hội trên địa bàn tỉnh Quảng Nam. Theo đó, Ban Chỉ đạo liên ngành về ATTP đã thanh, kiểm tra được 18.700 cơ sở, qua đó phát hiện  2.600 cơ sở vi phạm, 96 cơ sở vi phạm phải phạt tiền trên 127 triệu đồng. Một số cơ sở thực phẩm còn bán hàng đã quá hạng sử dụng, không rõ nguồn gốc xuất xứ với 556 loại sản phẩm bị tiêu hủy của 420 cơ sở, với các mặt hàng như: bánh, kẹo, sữa, nước ngọt, rượu...","https://firebasestorage.googleapis.com/v0/b/testfirebase-888ef.appspot.com/o/bao32.jpg?alt=media&token=a3f92ae4-99e2-4ee1-a95c-3fca235d3322","Chính nỗi lo vì cũng sử dụng rượu tại quán tạp hóa mà 5 thanh niên trú cùng địa phương đã uống, sau đó xảy ra ngộ độc nên trong 2 ngày 15-16/3, hàng chục người dân thôn Pà Păng đã tức tốc tìm tới các bệnh viện để kiểm tra sức khỏe. Rất may, không có thêm trường hợp nào tử vong do ngộ độc."));
        arBao.add(new Bao("Hiệu quả các biện pháp sinh học phòng trừ sâu đục trái bưởi","https://firebasestorage.googleapis.com/v0/b/testfirebase-888ef.appspot.com/o/bao41.jpg?alt=media&token=4abda301-c571-4fde-86b1-76ce564e0760","2018/04/06 12:01:30","Gia đình ông Trần Văn Tài, xã An Hiệp, huyện Châu Thành (Bến Tre) trồng gần 1 ha bưởi da xanh. Do ông cho ra trái bưởi da xanh vào mùa nghịch nên các đối tượng gây hại cho cây bưởi rất nhiều nhất là sâu đục trái làm ảnh hưởng đến năng suất và chất lượng trái bưởi. Ông Tài sử dụng thuốc bảo vệ thực vật diệt sâu, nhưng sâu vẫn không giảm nhiều. Nếu ngưng thuốc thì sâu tấn công, còn phun nhiều thuốc thì vừa tốn kém vừa ảnh hưởng đến sản phẩm bưởi da xanh theo quy trình VietGAP trong khu vực và môi trường xung quanh. Sau đó, ông được tập huấn áp dụng các biện pháp sinh học phòng trừ sâu hại và học hỏi thêm từ các hộ trồng bưởi áp dụng các biện pháp sinh học trên địa bàn.\n\nQua 3 năm áp dụng các biện pháp sinh học phòng trừ sâu đục trái mang lại hiệu quả lớn cho vườn bưởi của gia đình. Ông Tài cho biết, đầu tiên ông gom trái bị sâu xử lý diệt sâu non bằng nước vôi để tránh sâu còn trong trái sẽ trưởng thành. Đồng thời, ông bắt kiến vàng về nuôi lại, do trước đó sử dụng thuốc trừ sâu đã diệt luôn kiến vàng. Đây là loài thiên địch diệt tất cả các loại sâu gây hại. Bên cạnh đó, ông Tài trồng các loại cây có hoa màu sắc sặc sỡ, nhiều mật… vừa tạo độ ẩm cho vườn cây, chống xói mòn trong mùa mưa, hạn chế cỏ dại vừa tạo điều kiện thu hút nguồn ong ký sinh (ong mắt đỏ, ký sinh trong trứng sâu đục trái bưởi) phát triển trong vườn để tiêu diệt sâu hại.\n\nTheo ông Tài, sau 1 tháng đậu trái tiến hành tỉa trái (loại bỏ trái phát triển kém, méo mó, chỉ nên để 1-2 trái /chùm). Trước khi bao trái bằng vải lưới, sử dụng dầu khoáng phun để \"vệ sinh\" trái và không sử dụng bất kỳ loại thuốc nào để phòng trừ sâu đục trái sau khi bao. Nhờ áp dụng các biện pháp sinh học, vườn bưởi nhà ông Tài phát triển xanh tốt không còn sâu hại như lúc trước, giảm được chi phí vật tư. Hiện nay, mỗi năm ông Tài thu hoạch hơn 20 tấn bưởi da xanh, lợi nhuận hơn 500 triệu đồng.","https://firebasestorage.googleapis.com/v0/b/testfirebase-888ef.appspot.com/o/bao41.jpg?alt=media&token=4abda301-c571-4fde-86b1-76ce564e0760","Nhiều hộ nông dân trồng bưởi da xanh ở Bến Tre áp dụng các biện pháp sinh học phòng tránh sâu hại. Qua đó, chất lượng trái bưởi ngon hơn an toàn hơn khi đến tay người tiêu dùng.\n\nÔng Vương Thành Công,  Tổ trưởng tổ hợp tác trồng bưởi da xanh xã An Hiệp, huyện Châu Thành cho biết, các thành viên trong tổ trồng bưởi da xanh áp dụng quy trình VietGAP để sản xuất. Do đó việc áp dụng các biện pháp sinh học phòng tránh sâu hại mang lại hiệu quả rất lớn, giúp người nông dân không sử dụng thuốc trừ sâu trên vườn bưởi, tránh ảnh hưởng đến môi trường. Quan trọng nhất, chất lượng trái bưởi được đảm bảo, an toàn cho người dùng, từng bước đưa trái bưởi da xanh Bến Tre tiêu thụ rộng rãi ra thị trường ngoài nước, ông Công chia sẻ.\n\nTheo Sở Nông nghiệp và Phát triển nông thôn tỉnh Bến Tre, hiện nay có khoảng 16 ha diện tích cây bưởi da xanh bị sâu đục trái gây hại, trong tổng số 7.200 ha bưởi toàn tỉnh, giảm rất nhiều so với trước dây.\n\nÔng Nguyễn Văn Nam, Chi cục trưởng Chi cục Trồng trọt và Bảo vệ thực vật tỉnh Bến Tre cho biết, các biện pháp sinh học phòng trừ sâu hại như sử dụng thiên địch, bao trái, sử dụng chế phẩm sinh học…đã phát huy hiệu quả trong việc sản xuất trái bưởi da xanh. Bên cạnh đó, hướng dẫn áp dụng các biện pháp sinh học làm thay đổi tập quán sản xuất của người nông dân, giúp người nông dân không sử dụng thuốc trừ sâu độc hại, sản xuất theo tiêu chuẩn VietGAP từng bước định hướng sản xuất theo hướng hữu cơ. Từ đó, cho ra các loại sản phẩm sạch, an toàn, đáp ứng điều kiện khắt khe về an toàn vệ sinh thực phẩm của các thị trường xuất khẩu./."));
        arBao.add(new Bao("Hải Phòng: Thu trên 82 tỷ đồng từ công tác chống buôn lậu, gian lận thương mại","https://firebasestorage.googleapis.com/v0/b/testfirebase-888ef.appspot.com/o/bao51.JPG?alt=media&token=e354f99f-da87-4227-8da8-223b2e327bd4","2018/04/06 12:01:30","Quý I/2018, lực lượng chức năng  toàn Tỉnh đã thực hiện thu ngân sách nhà nước 29,637 tỷ đồng, trong đó, phạt vi phạm hành chính 13,828 tỷ  đồng; Phạt bổ sung, truy thu thuế 15,183 tỷ đồng; Bán hàng tịch thu 626 triệu đồng; Khởi tố 102 vụ/136 đối tượng.\n\nHoạt động xuất, nhập khẩu trên địa bàn tỉnh Thanh Hóa tương đối ổn định. Tuyến biên giới đường bộ (cửa khẩu Quốc tế Na Mèo và cửa khẩu Tén Tằn) hàng hóa xuất khẩu chủ yếu là vật liệu xây dựng (xi măng, thép xây dựng,...), hàng tiêu dùng; Hàng nhập khẩu chủ yếu là gỗ đã chế biến, nan, nứa thanh… Tuyến cảng biển, cảng sông (cảng Lễ Môn, Nghi Sơn) hàng hóa xuất khẩu chủ yếu là đá trắng, gỗ dăm, xi măng; Hàng hóa nhập khẩu chủ yếu là than cám; Các mặt hàng tạm nhập - tái xuất chủ yếu là thiết bị máy móc phục vụ cho dự án khu công nghiệp trên địa bàn.","https://firebasestorage.googleapis.com/v0/b/testfirebase-888ef.appspot.com/o/bao52.jpeg?alt=media&token=313226b5-a4b7-4559-900e-d966b9c0c613","Tình hình buôn lậu, gian lận thương mại và hàng giả trên địa bàn tỉnh tuy không nổi cộm nhưng vẫn còn tiềm ẩn những yếu tố phức tạp, khó lường; tình trạng vận chuyển, tàng trữ, buôn bán trái phép hàng cấm, hàng lậu, hàng không đảm bảo vệ sinh an toàn thực phẩm vẫn còn diễn ra. Trước tình hình đó, Ban Chỉ đạo 389 tỉnh đã triển khai nhiều biện pháp quyết liệt nhằm phát hiện, ngăn chặn, xử lý kịp thời vi phạm.\n\nVụ việc điển hình có thể kể đến là: Ngày 28/02/2018, Chi cục Quản lý thị trường tỉnh Thanh Hóa trình Chủ tịch UBND tỉnh ban hành Quyết định xử phạt vi phạm hành chính đối với ông Lê Văn Hòa, có địa chỉ tại thị xã Hương Thủy, tỉnh Thừa Thiên Huế về hành vi vận chuyển thuốc lá điếu nhập lậu. Phạt tiền 85 triệu đồng; Tịch thu 3.000 bao thuốc lá nhãn hiệu HERO; 440 bao thuốc lá điếu nhãn hiệu ESSE GOLDEN LEAF; 80 bao thuốc lá điếu nhãn hiệu ESSE Ligts; 120 bao thuốc lá điếu nhãn hiệu ESSE Classic do nước ngoài sản xuất"));
        arBao.add(new Bao("Nâng cao chất lượng và thương hiệu cho trái na Chi Lăng","https://firebasestorage.googleapis.com/v0/b/testfirebase-888ef.appspot.com/o/bao61.jpg?alt=media&token=b3e456a8-5ed2-41e3-aff6-946ce3f9e64f","2018/04/06 12:01:30","Cây na được người dân trồng chủ yếu ở các thung lũng và trên sườn núi đá vôi đã cho quả một vị ngọt thanh, đậm mang đặc trưng riêng. Cũng nhờ loài cây này mà nhiều hộ đồng bào dân tộc Tày, Nùng… nơi đây có cuộc sống sung túc, no đủ hơn, có thêm điều kiện để vươn lên thoát nghèo, có của ăn, của để.\n\nNhững ngày đầu tháng 4 dương lịch, người dân trồng na tại thị trấn Chi Lăng, huyện Chi Lăng, tỉnh Lạng Sơn đã hoàn thành xong khâu làm cỏ, bón phân gốc và cắt tỉa cành cho cây, trước mùa na ra hoa.\n\nĐược cán bộ nông nghiệp cơ sở tuyên truyền, hướng dẫn, người dân trồng na đã thực hiện đúng các quy trình chăm sóc cây theo hướng sản xuất nông nghiệp tốt để nâng cao năng suất, chất lượng, tạo sản phẩm na sạch, đảm bảo an toàn vệ sinh thực phẩm.\n\nAnh Đỗ Đăng Hưng, thôn Minh Hòa, thị trấn Chi Lăng, huyện Chi Lăng, tỉnh Lạng Sơn chia sẻ: “Gia đình có trồng khoảng hơn 1.000 cây na. Cán bộ nông nghiệp về hướng dẫn cho gia đình cách chăm sóc, bón phân đúng loại và vừa phải, tỉa cành đúng kỹ thuật và quy trình nên cây lên mầm non đều và không thấy có hiện tượng sâu bệnh. Theo kinh nghiệm của gia đình, vườn thoáng thì quả na mới to, cho năng suất cao được.","https://firebasestorage.googleapis.com/v0/b/testfirebase-888ef.appspot.com/o/bao61.jpg?alt=media&token=b3e456a8-5ed2-41e3-aff6-946ce3f9e64f","Thị trấn Chi Lăng, huyện Chi Lăng có khoảng trên 488 ha trồng na, chiếm 75% diện tích trồng các loại cây ăn quả; trong đó, diện tích thực hành sản xuất theo chuẩn VietGAP là gần 8,5 ha, tập trung tại Lân Ba Tài.\n\nÔng Triệu Minh Hiếu, Chủ tịch Hội Nông dân thị trấn Chi Lăng, huyện Chi Lăng, tỉnh Lạng Sơn cho biết, cây na thường ra quả và chín rộ vào thời điểm tháng 6 - 7 dương lịch. Trước thời gian đó, để chất lượng và sản lượng đạt kết quả tốt, người dân cùng với các cán bộ nông nghiệp đã tích cực trao đổi kinh nghiệm lẫn nhau, áp dụng khoa học kỹ thuật vào chăm sóc. Nhờ đó, năng xuất và sản lượng quả được nâng lên qua từng năm. Hiện nay, sản lượng na đạt khoảng 33.700 tấn/năm. Quả na đã được cấp nhãn hiệu “Na Chi Lăng” và được công nhận vào top 50 đặc sản trái cây nổi tiếng Việt Nam”.\n\nHuyện Chi Lăng hiện có gần 100 ha trồng na theo tiêu chuẩn VietGAP, tập trung ở các xã Chi Lăng, xã Quang Lang và thị trấn Chi Lăng. Thời gian qua, nhiều hộ dân trên địa bàn đã tham gia ký cam kết sản xuất na đảm bảo vệ sinh an toàn thực phẩm cũng như tích cực chăm sóc theo hướng sản xuất nông nghiệp tốt.\n\nÔng Đặng Văn Hiếu, Phó trưởng phòng Nông nghiệp và Phát triển nông thôn huyện Chi Lăng, tỉnh Lạng Sơn cho biết, với hướng sản xuất nông nghiệp tốt, ngành nông nghiệp chú trọng hướng dẫn bà con cách sử dụng thuốc bảo vệ thực vật tuân thủ theo nguyên tắc 4 đúng: đúng thuốc, đúng liều lượng và nồng độ, đúng lúc, đúng cách; sử dụng phân bón có nguồn gốc xuất xứ rõ ràng.\n\nCơ quan chuyên môn nông nghiệp địa phương cũng tăng cường khuyến cáo các hộ dân trồng na đồng loạt sử dụng phương pháp đặt bẫy Pheromone – một sản phẩm đảm bảo an toàn vệ sinh thực phẩm cũng như bảo vệ môi trường sinh thái để phòng trừ ruồi đục quả, để hạn chế việc lạm dụng thuốc bảo vệ thực vật...\n\n “Na Chi Lăng” đã có nhãn hiệu chứng nhận sản phẩm và được nhiều địa phương trong cũng như ngoài nước biết đến. Đặc biệt, để quảng bá sản phẩm nông sản chủ lực trên, hàng năm, huyện Chi Lăng có tổ chức Ngày hội Na Chi Lăng, qua đó từng bước xây dựng chuỗi giá trị cho đặc sản Na Chi Lăng theo hướng bền vững./"));
        arBao.add(new Bao("Doanh nghiệp thủy hải sản Việt Nam thấm thía với tấm 'thẻ vàng' từ EC","https://firebasestorage.googleapis.com/v0/b/testfirebase-888ef.appspot.com/o/bao81.jpg?alt=media&token=cca470ca-e714-4c0b-883d-01a3482269c7","2018/04/06 12:01:30","Sáng qua 5/4 tại TP Nha Trang (Khánh Hòa), Bộ NN&PTNT đã tổ chức Hội nghị bàn giải pháp khai thác, bảo quản, chế biến, tiêu thụ sản phẩm hải sản khai thác nhằm thúc đẩy xuất khẩu hải sản Việt Nam, đặc biệt là chỉnh sửa Thông tư 02/2018 để nỗ lực xóa “thẻ vàng” từ Liên minh châu Âu (EU).\n\n“Không thể để sản phẩm có chất lượng tốt như vậy mà chế biến sơ sài. Phải thay đổi để chất lượng thủy hải sản Việt Nam tốt hơn nữa”, Bộ trưởng Bộ NN&PTNT Nguyễn Xuân Cường nói.\n\nTại hội nghị, các doanh nghiệp xuất khẩu thủy hải sản đều bày tỏ nỗi thấm thía với tấm “thẻ vàng” khắt khe từ Ủy ban châu Âu (EC). Bà Cao Thị Kim Lan- Giám đốc Công ty cổ phần Thủy hải sản Bình Định, cho biết: “Công ty chúng tôi đã chịu rất nhiều thiệt hại từ tấm thẻ phạt. Trong khi sản lượng cá ngừ đại dương xuất khẩu của công ty chiếm 75% cả nước, và có đến 70% xuất khẩu sang EU”.\n\n“Nếu bị chuyển sang “thẻ đỏ”, chúng ta sẽ bị cấm xuất khẩu hải sản sang thị trường EU (với kim ngạch 400-450 triệu USD/ năm)” - ông Nguyễn Hoài Nam - Phó Tổng thư ký Hiệp hội VASEP bày tỏ nỗi lo lắng. “Chương trình giám sát thủy sản xuất khẩu (Simp) của Mỹ áp dụng cho 13 loài (bào ngư, cá tuyết, cá ngừ, ghẹ xanh,…) năm 2019 sẽ áp dụng cho tôm. Con tôm Việt Nam sẽ phải chịu những rủi ro rất lớn”, ông Nam cho biết thêm.","https://firebasestorage.googleapis.com/v0/b/testfirebase-888ef.appspot.com/o/bao82.jpg?alt=media&token=bb397de0-f622-4c23-8647-22536b09c56f","Việc vực dậy sau thẻ phạt còn gặp nhiều khó khăn khi nhiều điều lệ trong Thông tư số 02/2018 còn chưa hoàn thiện. Ông Thành Nam, đại diện Công ty Hải Vương cho biết: hiện công ty vẫn còn rất nhiều lô hàng hải sản bị “chặn đứng” tại cửa khẩu vì thị trường nước ngoài yêu cầu cơ quan chức năng của Việt Nam xác nhận nguồn gốc. Tuy nhiên không có bất cứ cơ quan nào thực hiện. Hơn nữa, phí thẩm định khá cao 700.000 đồng/lần cho mọi khối lượng hàng.\n\nBên cạnh đó, những thiếu sót trong Thông tư 02 còn là rào cản trong việc mua nguyên liệu, nhật ký tàu,… cho việc xuất khẩu. Cụ thể trường hợp Công ty Việt Cường (Tiền Giang) từ ngày 7/3 đến ngày 5/4 doanh nghiệp bơ vơ, không mua được nguyên liệu vì chi cục không xác nhận.\n\nVấn đề về vệ sinh an toàn thực phẩm tại cảng cá cũng là điều đáng báo động. Theo phản ánh của Chi cục Thủy hải sản tỉnh Phú Yên, các ngư dân rã đá bằng nước sông quanh khu đậu thuyền. Các tàu cá không về nhập cảng mà về thẳng chủ hàng. Điều này càng gây khó khăn trong việc quản lý vệ sinh để đảm bảo cho nguồn hàng xuất khẩu sạch. \n Tại Hội nghị, Bộ NN& PTNT quyết định tháo gỡ Thông tư 02/2018. Thay vào đó sẽ giao cho Cục quản lý chất lượng Thủy sản (NAFIQAD) thuộc Bộ cấp giấy ICCAT phục vụ xuất khẩu từ 1/5/2018. Trong thời gian giao thoa đến 1/5/2018. Bộ cũng đề nghị các DN tiếp tục được cấp giấy chứng nhận ICCAT tại các chi cục để không gián đoạn xuất khẩu, đồng thời, giảm mức phí cấp giấy chứng nhận xuống còn 200.000 đồng/ lần.\n\nThứ trưởng cũng cho biết, tháng 5 tới sẽ có đoàn cấp cao của EU đến Việt Nam để đánh giá thực địa. Và nhiệm vụ của DN và các chi cục phải thực hiện các giải pháp được đưa ra hiệu quả. Đặc biệt phải thực hiện tốt việc truy xuất nguồn gốc và chống đánh bắt bất hợp pháp. Đây cũng là một bước tiến triển tốt trong việc EU rút thẻ vàng.\n\nBộ trưởng Bộ NN&PTNT ông Nguyễn Xuân Cường cũng nhận định phải thay đổi và nâng cao khâu chế biến. “Không thể để sản phẩm có chất lượng tốt như vậy mà chế biến sơ sài. Phải thay đổi để chất lượng thủy hải sản Việt Nam tốt hơn nữa”, ông Cường nhấn mạnh. Theo đó, Bộ cũng hướng các doanh nghiệp đến việc chế biến sâu nâng cao giá trị xuất khẩu, giảm thất thoát xuống 10%. Và sắp tới sẽ chuyển giao các công nghệ mới đến từng tàu một. "));
        int i = 0;
        for(Bao x:arBao){
            x.setIDBao(i);
            i++;
            x.setSolove(0);
            x.setSoshare(0);
            mDatabase.child("Bao").child(""+x.getIDBao()).setValue(x);
        }
        Toast.makeText(getBaseContext(),"OK",Toast.LENGTH_SHORT).show();
    }
    public void initBaoHot(){
        TinHot = new Bao("Cô bán thịt có tâm: Mắc màn kín quầy để ruồi muỗi hết đường tiếp cận","https://firebasestorage.googleapis.com/v0/b/thefoodhouse3.appspot.com/o/2957092820797668522574114073262554117453869n-1522468999593898455842.jpg?alt=media&token=0c1d0f20-355d-4782-8a51-a243078b11ed","2018/04/06 12:01:30","Các hàng thịt ở chợ ven đường được bày bán khiến người mua lo lắng về vấn đề vệ sinh vệ sinh. Hầu như chỉ cần một tấm ván gỗ kê cao hay vỏ bao là đã có ngay một gian hàng nằm sát lề đường. Mặc dù ở những khu vực này số lượng xe đi qua khá nhiều, cùng với đó là bụi bẩn mù mịt và cả ruồi muỗi, thế nhưng hầu như những quầy bán thịt ấy không hề có một phương thức che chắn nào.\n" +
                "\n" +
                "Mới đây, một gian hàng bán thịt ở Hải phòng đã nghĩ ra một cách vô cùng độc đáo để hạn chế bụi bẩn và ruồi, đó là mắc cả một cái màn quanh khu vực bán hàng của mình. Nhìn từ xa gian hàng thịt này như một căn phòng thu nhỏ, ai muốn mua thì có thể đứng ngoài hoặc vào trong màn để lựa thịt mua mang về.","https://firebasestorage.googleapis.com/v0/b/thefoodhouse3.appspot.com/o/2957294420797668455907454458917911195988210n-1522468999597961030156.jpg?alt=media&token=d3928403-6167-4813-ae4a-6b33daf24845","Sau khi đăng lên mạng xã hội, những bức ảnh này đã thu hút sự chú ý của nhiều người dùng Facebook khi nhận được hàng nghìn like và bình luận. Đa phần mọi người đều cho rằng đây là một cách khá độc đáo, cũng góp phần giúp khách hàng yên tâm hơn về chất lượng thịt mà mình đã mua.");
        TinHot.setIDBao(999);
        TinHot.setGioithieu("Những phản thịt bày bán ven đường không tránh thể khỏi bụi bẩn và ruồi, chính vì thế một chủ quầy thịt ở Hải Phòng đã nảy ra sáng kiến mắc màn cho sạch sẽ.");
        TinHot.setSolove(6969);
        TinHot.setSoshare(9696);
        mDatabase.child("TinHot").setValue(TinHot);
        Toast.makeText(getApplicationContext(),"Update Tin Hot",Toast.LENGTH_SHORT).show();
    }
    public void initBaoLove(){
        for(int i=0; i < 5; i++){
            for(int x=0; x<=6; x++){
                mDatabase.child("BaoLove").child(""+i).child(""+x).setValue(false);
            }
            mDatabase.child("BaoLove").child(""+i).child(""+999).setValue(false);
        }
        Toast.makeText(getApplicationContext(),"Update Bao Love",Toast.LENGTH_SHORT).show();
    }
    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("dnv_config_bao.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
