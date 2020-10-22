/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/3/24 18:13:01                           */
/*==============================================================*/


drop table if exists maro_client__evaluate;

drop table if exists maro_client__foodorder;

drop table if exists maro_client__serverorder;

drop table if exists maro_client_payed;

drop table if exists maro_client_reserve;

drop table if exists maro_client_reserve_foodorder;

drop table if exists maro_client_seatchange;

drop table if exists maro_client_serverorderlog;

/*==============================================================*/
/* Table: maro_client__evaluate                                 */
/*==============================================================*/
create table maro_client__evaluate
(
   id                   int,
   restaurant_id        varchar(36),
   server_order_id      varchar(36),
   food_order_id        varchar(36),
   happen_time          bigint,
   lever                int,
   content              varchar(1000),
   customer_name        varchar(20),
   phone                varchar(11)
);

/*==============================================================*/
/* Table: maro_client__foodorder                                */
/*==============================================================*/
create table maro_client__foodorder
(
   id                   varchar(36) not null,
   restaurant_id        varchar(36),
   server_order_id      varchar(36),
   food_type            varchar(20),
   food_type_code       varchar(36),
   food_name            varchar(20),
   food_code            varchar(36),
   quantity             decimal(5,2),
   unit_code            varchar(10),
   unit_name            varchar(5),
   price                decimal(6,2),
   total_price          decimal(6,2),
   waiter_id            varchar(36),
   waiter_name          varchar(20),
   discount             decimal(2,1),
   status               int,
   type                 int,
   primary key (id)
);

alter table maro_client__foodorder comment '点餐订单';

/*==============================================================*/
/* Table: maro_client__serverorder                              */
/*==============================================================*/
create table maro_client__serverorder
(
   id                   varchar(36) not null,
   code                 varchar(20),
   restaurant_id        varchar(36),
   restaurant_name      varchar(20),
   dest_seat_id         varchar(36),
   src_seat_code        varchar(5),
   src_seat_name        varchar(20),
   amount               decimal(6,2),
   begin_time           bigint,
   person_number        int,
   waiter_id            varchar(36),
   waiter_name          varchar(20),
   service_charge       decimal(5,2),
   payed_deposit        decimal(6,0),
   status               int,
   pay_type             int,
   pay_terminal         int,
   cashier_id           varchar(36),
   cashier_name         varchar(20),
   pay_time             bigint,
   end_time             bigint,
   remark               varchar(1000),
   reserve_id           varchar(36),
   discount             decimal(2,1),
   pay_amount           decimal(10,2),
   receivable_amount    decimal(10,2),
   collected_amount     decimal(10,2),
   make_bill_type       int,
   customer_name        varchar(20),
   phone                varchar(11),
   member_id            varchar(36),
   member_name          varchar(20),
   member_phone         varchar(11),
   cook_id              varchar(36),
   cook_name            varchar(20),
   primary key (id)
);

alter table maro_client__serverorder comment '店铺服务订单流水记录';

/*==============================================================*/
/* Table: maro_client_payed                                     */
/*==============================================================*/
create table maro_client_payed
(
   id                   varchar(36) not null,
   pay_time             bigint,
   pay_type             int,
   pay_terminal         int,
   card_number          varchar(20),
   primary key (id)
);

alter table maro_client_payed comment '服务订单支付记录';

/*==============================================================*/
/* Table: maro_client_reserve                                   */
/*==============================================================*/
create table maro_client_reserve
(
   id                   varchar(36) not null,
   restaurant_id        varchar(36),
   restaurant_name      varchar(20),
   dest_seat_id         varchar(36),
   src_seat_code        varchar(5),
   src_seat_name        varchar(20),
   customer_name        varchar(20),
   phone                varchar(11),
   person_number        int,
   reserve_time         bigint,
   type                 int,
   deposit              decimal(6,0),
   content              varchar(1000),
   status               int,
   period               int,
   primary key (id)
);

alter table maro_client_reserve comment '预定记录表';

/*==============================================================*/
/* Table: maro_client_reserve_foodorder                         */
/*==============================================================*/
create table maro_client_reserve_foodorder
(
   id                   varchar(36) not null,
   reserve_id           varchar(36),
   food_type            varchar(20),
   food_type_code       varchar(36),
   food_name            varchar(20),
   food_code            varchar(36),
   quantity             decimal(5,2),
   unit_code            varchar(10),
   unit_name            varchar(5),
   price                decimal(6,2),
   total_price          decimal(6,2),
   primary key (id)
);

alter table maro_client_reserve_foodorder comment '预定点餐订单';

/*==============================================================*/
/* Table: maro_client_seatchange                                */
/*==============================================================*/
create table maro_client_seatchange
(
   id                   varchar(36) not null,
   type                 int,
   name                 varchar(5),
   happen_time          bigint,
   src_seat_id          varchar(36),
   src_seat_code        varchar(5),
   src_seat_name        varchar(20),
   dest_seat_id         varchar(36),
   dest_seat_code       char(10),
   dest_seat_name       char(10),
   primary key (id)
);

alter table maro_client_seatchange comment '座位调整记录';

/*==============================================================*/
/* Table: maro_client_serverorderlog                            */
/*==============================================================*/
create table maro_client_serverorderlog
(
   id                   varchar(36) not null,
   happen_time          bigint,
   type                 int,
   description          varchar(500),
   primary key (id)
);

alter table maro_client_serverorderlog comment '服务订单日志';

