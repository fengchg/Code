package com.jfinal.weixin.demo;

import com.jfinal.core.Controller;
import com.jfinal.json.Json;
import com.jfinal.scan.SpringUtils;
import com.jfinal.weixin.sdk.api.CardApi;
import com.jfinal.weixin.sdk.api.MemberCardApi;
import com.jfinal.weixin.sdk.utils.JsonUtils;
import com.maro.common.users.member.server.MaroCommonMemberServiceI;

/**
 * Created by alpha on 2018-11-13.
 */
public class WeixinCardController extends Controller {
    private MaroCommonMemberServiceI memberCommonService = SpringUtils.getBean(MaroCommonMemberServiceI.class);

    protected String cardJosn ="{\n" +
            "    \"card\": {\n" +
            "        \"card_type\": \"MEMBER_CARD\",\n" +
            "        \"member_card\": {\n" +
//            "            \"background_pic_url\": null" +
            "            \"base_info\": {\n" +
            "                \"logo_url\": \"http://app.tuxingtianxia.com.cn/maro/upload/logo200.jpg\",\n" +
            "                \"brand_name\": \"兔行天下\",\n" +
            "                \"code_type\": \"CODE_TYPE_BARCODE\",\n" +
            "                \"title\": \"VIP会员卡\",\n" +
            "                \"color\": \"Color010\",\n" +
            "                \"notice\": \"使用时向服务员出示此券\",\n" +
            "                \"service_phone\": \"028-62615851\",\n" +
            "                \"description\": \"不可与其他优惠同享\",\n" +
            "                \"date_info\": {\n" +
            "                    \"type\": \"DATE_TYPE_PERMANENT\"\n" +
            "                },\n" +
            "                \"sku\": {\n" +
            "                    \"quantity\": 50000000\n" +
            "                },\n" +
            "                \"get_limit\": 1,\n" +
            "                \"use_custom_code\": false,\n" +
            "                \"can_give_friend\": false,\n" +
            "                \"use_all_locations\": true,\n"+
//                "                \"location_id_list\": [\n" +
//                "                    123,\n" +
//                "                    12321\n" +
//                "                ],\n" +
            "                \"custom_url_name\": \"立即使用\",\n" +
            "                \"custom_url\": \"http://weixin.qq.com\",\n" +
            "                \"custom_url_sub_title\": \"快速买单折扣\",\n" +
            "                \"promotion_url_name\": \"品牌加盟\",\n" +
            "                \"promotion_url\": \"https://mp.weixin.qq.com/s/I4qZ2JfON_b8NaEIAiANpA\",\n" +
            "                \"need_push_on_view\": true\n" +
            "            },\n" +
            "             \"advanced_info\": {\n" +
//            "               \"abstract\": {\n" +
//                "                   \"abstract\": \"微信餐厅推出多种新季菜品，期待您的光临\",\n" +
//                "                   \"icon_url_list\": [\n" +
//                "                       \"http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0\"\n" +
//                "                   ]\n" +
//                "               },\n" +
//                "               \"text_image_list\": [\n" +
//                "                   {\n" +
//                "                       \"image_url\": \"http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0\",\n" +
//                "                       \"text\": \"此菜品精选食材，以独特的烹饪方法，最大程度地刺激食 客的味蕾\"\n" +
//                "                   },\n" +
//                "                   {\n" +
//                "                       \"image_url\": \"http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sj piby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0\",\n" +
//                "                       \"text\": \"此菜品迎合大众口味，老少皆宜，营养均衡\"\n" +
//                "                   }\n" +
//                "               ],\n" +
//                "               \"time_limit\": [\n" +
//                "                   {\n" +
//                "                       \"type\": \"MONDAY\",\n" +
//                "                       \"begin_hour\":0,\n" +
//                "                       \"end_hour\":10,\n" +
//                "                       \"begin_minute\":10,\n" +
//                "                       \"end_minute\":59\n" +
//                "                   },\n" +
//                "                   {\n" +
//                "                       \"type\": \"HOLIDAY\"\n" +
//                "                   }\n" +
//                "               ],\n" +
            "               \"business_service\": [\n" +
            "                   \"BIZ_SERVICE_FREE_WIFI\",\n" +
            "                   \"BIZ_SERVICE_WITH_PET\",\n" +
            "                   \"BIZ_SERVICE_FREE_PARK\",\n" +
            "                   \"BIZ_SERVICE_DELIVER\"\n" +
            "               ]\n" +
            "           },\n" +
            "            \"supply_bonus\": true,\n" +
            "            \"supply_balance\": false,\n" +
            "            \"prerogative\": \"积分可换礼品哦\",\n" +
            "            \"auto_activate\": false,\n" +
            "            \"wx_activate\": true,\n" +
//            "            \"activate_url\": \"http://app.tuxingtianxia.com.cn/maro/weixin/card/activate\",\n" +
            "            \"custom_field1\": {\n" +
            "                \"name_type\": \"FIELD_NAME_TYPE_LEVEL\",\n" +
            "                \"url\": \"http://www.qq.com\"\n" +
            "            },\n" +
            "            \"custom_cell1\": {\n" +
            "                \"name\": \"使用入口2\",\n" +
            "                \"tips\": \"激活后显示\",\n" +
            "                \"url\": \"http://www.xxx.com\"\n" +
            "            },\n" +
            "            \"bonus_rule\": {\n" +
            "                \"cost_money_unit\": 100,\n" +
            "                \"increase_bonus\": 1,\n" +
            "                \"max_increase_bonus\": 1000,\n" +
            "                \"init_increase_bonus\": 0,\n" +
            "                \"cost_bonus_unit\": 100,\n" +
            "                \"reduce_money\": 100,\n" +
            "                \"least_money_to_use_bonus\": 1000,\n" +
            "                \"max_reduce_bonus\": 10000\n" +
            "            },\n" +
            "            \"discount\": 1\n" +
            "        }\n" +
            "    }\n" +
            "}";
    //删除
    public void delete(){
        String id= getPara("id");
        renderText(CardApi.delete(id).getJson());
    }
    //卡券列表
    public void getBatch(){
        renderText(CardApi.getBatch(0,50).getJson());
    }
    //创建卡
    public void create(){
        renderText(CardApi.create(cardJosn).getJson());
    }
    //修改卡
    public void update(){
        //生产card_id pg68E1pHwP8MTxMuvbg0OXANTASg
        String cardUpdateJson="{\n" +
                        "   \"card_id\": \"pg68E1pHwP8MTxMuvbg0OXANTASg\",\n"+
                        "   \"member_card\": {\n" +
                        "            \"wx_activate\": true,\n" +
                        "            \"activate_url\": null\n" +
                        "    }\n" +
                        "}";
        renderText(CardApi.update(cardUpdateJson).getJson());
    }
    //设置激活内容
    public void formSet(){
        String cardId=getPara("cardId");
        String form="{\n" +
                "    \"card_id\": \""+cardId+"\",\n" +
                "    \"service_statement\": {\n" +
                "        \"name\": \"会员守则\",\n" +
                "        \"url\": \"http://app.tuxingtianxia.com.cn/maro/weixin/member/statement\"\n" +
                "    },\n" +
                "    \"bind_old_card\": {\n" +
                "        \"name\": \"老会员绑定\",\n" +
                "        \"url\": \"http://3jn5u7.natappfree.cc/maro/weixin/member/\"\n" +
                "    },\n" +
                "    \"required_form\": {\n" +
                "        \"can_modify\":false,\n" +
                "        \"common_field_id_list\": [\n" +
                "            \"USER_FORM_INFO_FLAG_MOBILE\"\n" +
                "        ]\n" +
                "    },\n" +
                "    \"optional_form\": {\n" +
                "        \"can_modify\":false,\n" +
                "        \"common_field_id_list\": [\n" +
                "            \"USER_FORM_INFO_FLAG_NAME\",\n" +
                "            \"USER_FORM_INFO_FLAG_SEX\",\n" +
                "            \"USER_FORM_INFO_FLAG_BIRTHDAY\"\n" +
                "        ]\n" +
                "    }\n" +
                "}";

        renderText(MemberCardApi.setActivateUserForm(form).getJson());
    }

    public void getCard(){
        String cardId=getPara("cardId");
        renderText(CardApi.get(cardId).getJson());
    }

    public void qrcode(){
        String cardId=getPara("cardId");
        String json="{\"action_name\": \"QR_CARD\",\n" +
                    "   \"action_info\": {\n" +
                    "       \"card\": {\n" +
                    "           \"card_id\": \""+cardId+"\",\n" +
                    "           \"is_unique_code\": false ,\n" +
                    "           \"outer_str\":\"12b\"\n" +
                    "       }\n" +
                    "   }\n" +
                    "}";
        renderText(CardApi.createQrcode(json).getJson());
    }
    private void getMember(){
        renderText(JsonUtils.toJson(memberCommonService.getByPohne("13408035382")));
    }
}
