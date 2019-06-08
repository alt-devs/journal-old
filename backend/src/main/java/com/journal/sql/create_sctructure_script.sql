drop schema if exists journal;
create schema journal authorization postgres;

drop schema if exists nsi;
create schema nsi authorization postgres;

drop schema if exists admin;
create schema admin authorization postgres;

/*==============================================================*/
/* Table: client                                              				    */
/*==============================================================*/

drop index if exists journal.idx_client_id_company;
drop index if exists journal.idx_client_id;

drop table if exists journal.client;

create table journal.client (
   id                   NUMERIC              not null,
   id_company           NUMERIC              null,
   surname              VARCHAR(30)          null,
   name                 VARCHAR(30)          null,
   patronymic           VARCHAR(30)          null,
   birth_date           DATE                 null,
   gender               NUMERIC(1)           null,
   phone                VARCHAR(12)          null,
   email                VARCHAR(40)          null,
   constraint PK_CLIENT primary key (id)
);

create unique index idx_client_id on journal.client using BTREE (id);
create index idx_client_id_company on journal.client using BTREE (id_company);

drop sequence if exists journal.client_id_seq;
create sequence journal.client_id_seq;

alter table journal.client
    alter column id set default nextval('journal.client_id_seq');
	
	
/*==============================================================*/
/* Table: company                                               */
/*==============================================================*/

drop index if exists journal.idx_comp_id_currency;
drop index if exists journal.idx_comp_id;

drop table if exists journal.company;

create table journal.company (
   id                   NUMERIC              not null,
   id_currency          NUMERIC              null,
   name                 VARCHAR(100)         null,
   email                VARCHAR(40)          null,
   photo_path           VARCHAR(255)         null,
   description          VARCHAR(1024)        null,
   constraint PK_COMPANY primary key (id)
);

create unique index idx_comp_id on journal.company using BTREE (id);
create index idx_comp_id_currency on journal.company using BTREE (id_currency);

drop sequence if exists journal.company_id_seq;
create sequence journal.company_id_seq;

alter table journal.company
    alter column id set default nextval('journal.company_id_seq');


/*==============================================================*/
/* Table: company_address                                       */
/*==============================================================*/

drop index if exists journal.idx_compaddr_id_region;
drop index if exists journal.idx_compaddr_id_country;
drop index if exists journal.idx_compaddr_id_comp;
drop index if exists journal.idx_compaddr_id;

drop table if exists journal.company_address;

create table journal.company_address (
   id                   NUMERIC              not null,
   id_company           NUMERIC              null,
   id_country           NUMERIC              null,
   id_region            NUMERIC              null,
   district             VARCHAR(100)         null,
   locality             VARCHAR(100)         null,
   street               VARCHAR(100)         null,
   house                NUMERIC(3)           null,
   build                VARCHAR(5)           null,
   constraint PK_COMPANY_ADDRESS primary key (id)
);

create unique index idx_compaddr_id on journal.company_address using BTREE (id);
create index idx_compaddr_id_comp on journal.company_address using BTREE (id_company);
create index idx_compaddr_id_country on journal.company_address using BTREE (id_country);
create index idx_compaddr_id_region on journal.company_address using BTREE (id_region);

drop sequence if exists journal.company_address_id_seq;
create sequence journal.company_address_id_seq;

alter table journal.company_address
    alter column id set default nextval('journal.company_address_id_seq');


/*==============================================================*/
/* Table: company_area                                          */
/*==============================================================*/

drop index if exists journal.idx_comparea_id_ind_area;
drop index if exists journal.idx_comparea_id_comp;
drop index if exists journal.idx_comparea_id;

drop table if exists journal.company_area;

create table journal.company_area (
   id                   NUMERIC              not null,
   id_company           NUMERIC              null,
   id_industry_area     NUMERIC              null,
   constraint PK_COMPANY_AREA primary key (id)
);

create unique index idx_comparea_id on journal.company_area using BTREE (id);
create index idx_comparea_id_comp on journal.company_area using BTREE (id_company);
create index idx_comparea_id_ind_area on journal.company_area using BTREE (id_industry_area);

drop sequence if exists journal.company_area_id_seq;
create sequence journal.company_area_id_seq;

alter table journal.company_area
    alter column id set default nextval('journal.company_area_id_seq');


/*==============================================================*/
/* Table: company_phone                                         */
/*==============================================================*/

drop index if exists journal.idx_comppho_id_comp;
drop index if exists journal.idx_comppho_id;
drop table if exists journal.company_phone;

create table journal.company_phone (
   id                   NUMERIC              not null,
   id_company           NUMERIC              null,
   phone                VARCHAR(12)          null,
   constraint PK_COMPANY_PHONE primary key (id)
);

create unique index idx_comppho_id on journal.company_phone using BTREE (id);
create index idx_comppho_id_comp on journal.company_phone using BTREE (id_company);

drop sequence if exists journal.company_phone_id_seq;
create sequence journal.company_phone_id_seq;

alter table journal.company_phone
    alter column id set default nextval('journal.company_phone_id_seq');


/*==============================================================*/
/* Table: company_schedule                                      */
/*==============================================================*/

drop index if exists journal.idx_compsched_id_comp;
drop index if exists journal.idx_compsched_id;
drop table if exists journal.company_schedule;

create table journal.company_schedule (
   id                   NUMERIC              not null,
   id_company           NUMERIC              null,
   days                 VARCHAR(7)           null,
   time_start           TIME                 null,
   time_end             TIME                 null,
   constraint PK_COMPANY_SCHEDULE primary key (id)
);

create unique index idx_compsched_id on journal.company_schedule using BTREE (id);
create index idx_compsched_id_comp on journal.company_schedule using BTREE (id_company);

drop sequence if exists journal.company_schedule_id_seq;
create sequence journal.company_schedule_id_seq;

alter table journal.company_schedule
    alter column id set default nextval('journal.company_schedule_id_seq');


/*==============================================================*/
/* Table: company_service                                       */
/*==============================================================*/

drop index if exists journal.idx_compserv_id_comp;
drop index if exists journal.idx_compserv_id_serv_cat;
drop index if exists journal.idx_compserv_id;
drop table if exists journal.company_service;

create table journal.company_service (
   id                   NUMERIC              not null,
   id_company_service_category NUMERIC              null,
   id_company           NUMERIC              null,
   name                 VARCHAR(255)         null,
   service_code         VARCHAR(10)          null,
   is_disabled          BOOL                 null,
   description          VARCHAR(512)         null,
   constraint PK_COMPANY_SERVICE primary key (id)
);

create unique index idx_compserv_id on journal.company_service using BTREE (id);
create index idx_compserv_id_serv_cat on journal.company_service using BTREE (id_company_service_category);
create index idx_compserv_id_comp on journal.company_service using BTREE (id_company);

drop sequence if exists journal.company_service_id_seq;
create sequence journal.company_service_id_seq;

alter table journal.company_service
    alter column id set default nextval('journal.company_service_id_seq');


/*==============================================================*/
/* Table: company_service_category                              */
/*==============================================================*/

drop index if exists journal.idx_compservcat_id;
drop index if exists journal.idx_compservcat_id_comp;
drop table if exists journal.company_service_category;

create table journal.company_service_category (
   id                   NUMERIC              not null,
   id_company           NUMERIC              null,
   name                 VARCHAR(100)         null,
   constraint PK_COMPANY_SERVICE_CATEGORY primary key (id)
);

create unique index idx_compservcat_id on journal.company_service_category using BTREE (id);
create  index idx_compservcat_id_comp on journal.company_service_category using BTREE (id_company);

drop sequence if exists journal.company_service_category_id_seq;
create sequence journal.company_service_category_id_seq;

alter table journal.company_service_category
    alter column id set default nextval('journal.company_service_category_id_seq');
	
	
/*==============================================================*/
/* Table: country                                               */
/*==============================================================*/

drop index if exists nsi.idx_country_id;
drop table if exists nsi.country;

create table nsi.country (
   id                   NUMERIC              not null,
   name                 VARCHAR(100)         null,
   constraint PK_COUNTRY primary key (id)
);

create unique index idx_country_id on nsi.country using BTREE (id);

drop sequence if exists nsi.country_id_seq;
create sequence nsi.country_id_seq;

alter table nsi.country
    alter column id set default nextval('nsi.country_id_seq');
	

/*==============================================================*/
/* Table: currency                                              */
/*==============================================================*/

drop index if exists nsi.idx_currency_id;
drop table if exists nsi.currency;

create table nsi.currency (
   id                   NUMERIC              not null,
   name                 VARCHAR(50)          null,
   constraint PK_CURRENCY primary key (id)
);

create unique index idx_currency_id on nsi.currency using BTREE (id);

drop sequence if exists nsi.currency_id_seq;
create sequence nsi.currency_id_seq;

alter table nsi.currency
    alter column id set default nextval('nsi.currency_id_seq');
	

/*==============================================================*/
/* Table: employee                                              */
/*==============================================================*/

drop index if exists journal.idx_employee_id_comp;
drop index if exists journal.idx_employee_id;
drop table if exists journal.employee;

create table journal.employee (
   id                   NUMERIC              not null,
   id_company           NUMERIC              null,
   surname              VARCHAR(30)          null,
   name                 VARCHAR(30)          null,
   patronymic           VARCHAR(30)          null,
   birth_date           DATE                 null,
   phone                VARCHAR(12)          null,
   "position"           VARCHAR(40)          null,
   constraint PK_EMPLOYEE primary key (id)
);

create unique index idx_employee_id on journal.employee using BTREE (id);
create index idx_employee_id_comp on journal.employee using BTREE (id_company);

drop sequence if exists journal.employee_id_seq;
create sequence journal.employee_id_seq;

alter table journal.employee
    alter column id set default nextval('journal.employee_id_seq');
	

/*==============================================================*/
/* Table: employee_schedule                                     */
/*==============================================================*/

drop index if exists journal.idx_empsched_id_employee;
drop index if exists journal.idx_empsched_id;
drop table if exists journal.employee_schedule;

create table journal.employee_schedule (
   id                   NUMERIC              not null,
   id_employee          NUMERIC              null,
   start_datetime       TIMESTAMP            null,
   end_datetime         TIMESTAMP            null,
   break_start_datetime TIMESTAMP            null,
   break_end_datetime   TIMESTAMP            null,
   reception_interval   NUMERIC(3)           null,
   constraint PK_EMPLOYEE_SCHEDULE primary key (id)
);

create unique index idx_empsched_id on journal.employee_schedule using BTREE (id);
create index idx_empsched_id_employee on journal.employee_schedule using BTREE (id_employee);

drop sequence if exists journal.employee_schedule_id_seq;
create sequence journal.employee_schedule_id_seq;

alter table journal.employee_schedule
    alter column id set default nextval('journal.employee_schedule_id_seq');


/*==============================================================*/
/* Table: employee_service                                      */
/*==============================================================*/

drop index if exists journal.idx_empserv_id_employee;
drop index if exists journal.idx_empserv_id_service;
drop index if exists journal.idx_empserv_id;
drop table if exists journal.employee_service;

create table journal.employee_service (
   id                   NUMERIC              not null,
   id_company_service   NUMERIC              null,
   id_employee          NUMERIC              null,
   duration             NUMERIC(3)           null,
   cost                 NUMERIC              null,
   is_floating_price    BOOL                 null,
   is_online_enable     BOOL                 null,
   constraint PK_EMPLOYEE_SERVICE primary key (id)
);

create unique index idx_empserv_id on journal.employee_service using BTREE (id);
create index idx_empserv_id_service on journal.employee_service using BTREE (id_company_service);
create index idx_empserv_id_employee on journal.employee_service using BTREE (id_employee);

drop sequence if exists journal.employee_service_id_seq;
create sequence journal.employee_service_id_seq;

alter table journal.employee_service
    alter column id set default nextval('journal.employee_service_id_seq');
	

/*==============================================================*/
/* Table: employee_service_category                             */
/*==============================================================*/

drop index if exists journal.idx_empservcat_id_serv_cat;
drop index if exists journal.idx_empservcat_id_empl;
drop index if exists journal.idx_empservcat_id;
drop table if exists journal.employee_service_category;

create table journal.employee_service_category (
   id                   NUMERIC              not null,
   id_employee          NUMERIC              null,
   id_company_service_category NUMERIC              null,
   constraint PK_EMPLOYEE_SERVICE_CATEGORY primary key (id)
);

create unique index idx_empservcat_id on journal.employee_service_category using BTREE (id);
create index idx_empservcat_id_empl on journal.employee_service_category using BTREE (id_employee);
create index idx_empservcat_id_serv_cat on journal.employee_service_category using BTREE (id_company_service_category);

drop sequence if exists journal.employee_service_category_id_seq;
create sequence journal.employee_service_category_id_seq;

alter table journal.employee_service_category
    alter column id set default nextval('journal.employee_service_category_id_seq');
	
	
/*==============================================================*/
/* Table: industry                                              */
/*==============================================================*/

drop index if exists nsi.idx_industry_id;
drop table if exists nsi.industry;

create table nsi.industry (
   id                   NUMERIC              not null,
   name                 VARCHAR(50)          null,
   constraint PK_INDUSTRY primary key (id)
);

create unique index idx_industry_id on nsi.industry using BTREE (id);

drop sequence if exists nsi.industry_id_seq;
create sequence nsi.industry_id_seq;

alter table nsi.industry
    alter column id set default nextval('nsi.industry_id_seq');


/*==============================================================*/
/* Table: industry_area                                         */
/*==============================================================*/

drop index if exists nsi.idx_indarea_id_industry;
drop index if exists nsi.idx_indarea_id;
drop table if exists nsi.industry_area;

create table nsi.industry_area (
   id                   NUMERIC              not null,
   id_industry          NUMERIC              null,
   name                 VARCHAR(100)         null,
   constraint PK_INDUSTRY_AREA primary key (id)
);

create unique index idx_indarea_id on nsi.industry_area using BTREE (id);
create index idx_indarea_id_industry on nsi.industry_area using BTREE (id_industry);

drop sequence if exists nsi.industry_area_id_seq;
create sequence nsi.industry_area_id_seq;

alter table nsi.industry_area
    alter column id set default nextval('nsi.industry_area_id_seq');
	
	
/*==============================================================*/
/* Table: journal                                               */
/*==============================================================*/

drop index if exists journal.idx_journal_id_service;
drop index if exists journal.idx_journal_id_client;
drop index if exists journal.idx_journal_id_employee;
drop index if exists journal.idx_journal_id;
drop table if exists journal.journal;

create table journal.journal (
   id                   NUMERIC              not null,
   id_employee          NUMERIC              null,
   id_client            NUMERIC              null,
   id_service           NUMERIC              null,
   start_datetime       TIMESTAMP            null,
   end_datetime         TIMESTAMP            null,
   duration             NUMERIC(3)           null,
   cost                 NUMERIC              null,
   client_name          VARCHAR(30)          null,
   client_phone         VARCHAR(12)          null,
   comment              VARCHAR(255)         null,
   constraint PK_JOURNAL primary key (id)
);

create unique index idx_journal_id on journal.journal using BTREE (id);
create index idx_journal_id_employee on journal.journal using BTREE (id_employee);
create index idx_journal_id_client on journal.journal using BTREE (id_client);
create index idx_journal_id_service on journal.journal using BTREE (id_service);

drop sequence if exists journal.journal_id_seq;
create sequence journal.journal_id_seq;

alter table journal.journal
    alter column id set default nextval('journal.journal_id_seq');
	

/*==============================================================*/
/* Table: link                                                  */
/*==============================================================*/

drop index if exists journal.idx_link_id_type_link;
drop index if exists journal.idx_link_id_company;
drop index if exists journal.idx_link_id;
drop table if exists journal.link;

create table journal.link (
   id                   NUMERIC              not null,
   id_company           NUMERIC              null,
   id_type_link         NUMERIC              null,
   link                 VARCHAR(40)          null,
   constraint PK_LINK primary key (id)
);

create unique index idx_link_id on journal.link using BTREE (id);
create  index idx_link_id_company on journal.link using BTREE (id_company);
create  index idx_link_id_type_link on journal.link using BTREE (id_type_link);

drop sequence if exists journal.link_id_seq;
create sequence journal.link_id_seq;

alter table journal.link
    alter column id set default nextval('journal.link_id_seq');
	
	
/*==============================================================*/
/* Table: region                                                */
/*==============================================================*/

drop index if exists nsi.idx_region_id_country;
drop index if exists nsi.idx_region_id;
drop table if exists nsi.region;

create table nsi.region (
   id                   NUMERIC              not null,
   id_country           NUMERIC              null,
   name                 VARCHAR(100)         null,
   constraint PK_REGION primary key (id)
);

create unique index idx_region_id on nsi.region using BTREE (id);
create  index idx_region_id_country on nsi.region using BTREE (id_country);

drop sequence if exists nsi.region_id_seq;
create sequence nsi.region_id_seq;

alter table nsi.region
    alter column id set default nextval('nsi.region_id_seq');
	

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/

drop index if exists admin.idx_role_id;
drop table if exists admin.role;

create table admin.role (
   id                   NUMERIC              not null,
   name                 VARCHAR(50)          null,
   secure_name          VARCHAR(50)          null,
   constraint PK_ROLE primary key (id)
);

create unique index idx_role_id on admin.role using BTREE (id);

drop sequence if exists admin.role_id_seq;
create sequence admin.role_id_seq;

alter table admin.role
    alter column id set default nextval('admin.role_id_seq');
	
	

/*==============================================================*/
/* Table: service                                               */
/*==============================================================*/

drop index if exists nsi.idx_service_id_serv_cat;
drop index if exists nsi.idx_service_id;
drop table if exists nsi.service;

create table nsi.service (
   id                   NUMERIC              not null,
   id_service_category  NUMERIC              null,
   name                 VARCHAR(100)         null,
   constraint PK_SERVICE primary key (id)
);

create unique index idx_service_id on nsi.service using BTREE (id);
create index idx_service_id_serv_cat on nsi.service using BTREE (id_service_category);

drop sequence if exists nsi.service_id_seq;
create sequence nsi.service_id_seq;

alter table nsi.service
    alter column id set default nextval('nsi.service_id_seq');
	

/*==============================================================*/
/* Table: service_category                                      */
/*==============================================================*/

drop index if exists nsi.idx_servcat_id;
drop table if exists nsi.service_category;

create table nsi.service_category (
   id                   NUMERIC              not null,
   name                 VARCHAR(100)         null,
   constraint PK_SERVICE_CATEGORY primary key (id)
);

create unique index idx_servcat_id on nsi.service_category using BTREE (id);

drop sequence if exists nsi.service_category_id_seq;
create sequence nsi.service_category_id_seq;

alter table nsi.service_category
    alter column id set default nextval('nsi.service_category_id_seq');

	
	
/*==============================================================*/
/* Table: session                                               */
/*==============================================================*/

drop index if exists admin.idx_session_id_user;
drop index if exists admin.idx_session_id;
drop table if exists admin.session;

create table admin.session (
   id                   NUMERIC              not null,
   id_user              NUMERIC              null,
   start_date_time      TIMESTAMP            null,
   end_date_time        TIMESTAMP            null,
   ip_address           VARCHAR(15)          null,
   operation_system     VARCHAR(100)         null,
   browser              VARCHAR(100)         null,
   id_type_device       NUMERIC(1)           null,
   screen_resolution    VARCHAR(12)          null,
   constraint PK_SESSION primary key (id)
);

create unique index idx_session_id on admin.session using BTREE (id);
create index idx_session_id_user on admin.session using BTREE (id_user);

drop sequence if exists admin.session_id_seq;
create sequence admin.session_id_seq;

alter table admin.session
    alter column id set default nextval('admin.session_id_seq');
	

/*==============================================================*/
/* Table: type_link                                             */
/*==============================================================*/

drop index if exists nsi.idx_typelink_id;
drop table if exists nsi.type_link;

create table nsi.type_link (
   id                   NUMERIC              not null,
   name                 VARCHAR(20)          null,
   icon                 VARCHAR(30)          null,
   constraint PK_TYPE_LINK primary key (id)
);

create unique index idx_typelink_id on nsi.type_link using BTREE (id);

drop sequence if exists nsi.type_link_id_seq;
create sequence nsi.type_link_id_seq;

alter table nsi.type_link
    alter column id set default nextval('nsi.type_link_id_seq');
	

/*==============================================================*/
/* Table: "user"                                                */
/*==============================================================*/

drop index if exists admin.idx_user_id_role;
drop index if exists admin.idx_user_id_empl;
drop index if exists admin.idx_user_id;
drop table if exists admin.user;

create table admin.user (
   id                   NUMERIC              not null,
   id_employee          NUMERIC              null,
   id_role              NUMERIC              not null,
   login                VARCHAR(50)          null,
   password             VARCHAR(32)          null,
   last_active          TIMESTAMP            null,
   created_at           TIMESTAMP            null,
   updated_at           TIMESTAMP            null,
   constraint PK_USER primary key (id)
);

create unique index idx_user_id on admin.user using BTREE (id);
create  index idx_user_id_empl on admin.user using BTREE (id_employee);
create  index idx_user_id_role on admin.user using BTREE (id_role);

drop sequence if exists admin.user_id_seq;
create sequence admin.user_id_seq;

alter table admin.user
    alter column id set default nextval('admin.user_id_seq');
	
	


alter table journal.client
   add constraint fk_client_ref_comp foreign key (id_company)
      references journal.company (id)
      on delete restrict on update restrict;

alter table journal.company
   add constraint fk_comp_ref_currency foreign key (id_currency)
      references nsi.currency (id)
      on delete restrict on update restrict;

alter table journal.company_address
   add constraint fk_addr_ref_country foreign key (id_country)
      references nsi.country (id)
      on delete restrict on update restrict;

alter table journal.company_address
   add constraint fk_compaddr_ref_comp foreign key (id_company)
      references journal.company (id)
      on delete restrict on update restrict;

alter table journal.company_address
   add constraint fk_compaddr_ref_region foreign key (id_region)
      references nsi.region (id)
      on delete restrict on update restrict;

alter table journal.company_area
   add constraint fk_comparea_ref_comp foreign key (id_company)
      references journal.company (id)
      on delete restrict on update restrict;

alter table journal.company_area
   add constraint fk_comparea_ref_indarea foreign key (id_industry_area)
      references nsi.industry_area (id)
      on delete restrict on update restrict;

alter table journal.company_phone
   add constraint fk_comppho_ref_comp foreign key (id_company)
      references journal.company (id)
      on delete restrict on update restrict;

alter table journal.company_schedule
   add constraint fk_compsched_ref_comp foreign key (id_company)
      references journal.company (id)
      on delete restrict on update restrict;

alter table journal.company_service
   add constraint fk_service_ref_company foreign key (id_company)
      references journal.company (id)
      on delete restrict on update restrict;

alter table journal.company_service
   add constraint fk_service_ref_servcat foreign key (id_company_service_category)
      references journal.company_service_category (id)
      on delete restrict on update restrict;

alter table journal.employee
   add constraint fk_employee_ref_company foreign key (id_company)
      references journal.company (id)
      on delete restrict on update restrict;

alter table journal.employee_schedule
   add constraint fk_empsched_ref_emp foreign key (id_employee)
      references journal.employee (id)
      on delete restrict on update restrict;

alter table journal.employee_service
   add constraint fk_empserv_ref_employee foreign key (id_employee)
      references journal.employee (id)
      on delete restrict on update restrict;

alter table journal.employee_service
   add constraint fk_empserv_ref_serv foreign key (id_company_service)
      references journal.company_service (id)
      on delete restrict on update restrict;

alter table journal.employee_service_category
   add constraint fk_empservcat_ref_emp foreign key (id_employee)
      references journal.employee (id)
      on delete restrict on update restrict;

alter table journal.employee_service_category
   add constraint fk_empservcat_ref_servcat foreign key (id_company_service_category)
      references journal.company_service_category (id)
      on delete restrict on update restrict;

alter table nsi.industry_area
   add constraint fk_indarea_ref_ind foreign key (id_industry)
      references nsi.industry (id)
      on delete restrict on update restrict;

alter table journal.journal
   add constraint fk_journal_ref_client foreign key (id_client)
      references journal.client (id)
      on delete restrict on update restrict;

alter table journal.journal
   add constraint fk_journal_ref_employee foreign key (id_employee)
      references journal.employee (id)
      on delete restrict on update restrict;

alter table journal.journal
   add constraint fk_journal_ref_service foreign key (id_service)
      references journal.company_service (id)
      on delete restrict on update restrict;

alter table journal.link
   add constraint fk_link_ref_company foreign key (id_company)
      references journal.company (id)
      on delete restrict on update restrict;

alter table journal.link
   add constraint fk_link_ref_typelink foreign key (id_type_link)
      references nsi.type_link (id)
      on delete restrict on update restrict;

alter table nsi.region
   add constraint fk_region_ref_country foreign key (id_country)
      references nsi.country (id)
      on delete restrict on update restrict;

alter table nsi.service
   add constraint fk_serv_ref_sservcat foreign key (id_service_category)
      references nsi.service_category (id)
      on delete restrict on update restrict;

alter table admin.session
   add constraint fk_session_ref_user foreign key (id_user)
      references admin.user (id)
      on delete restrict on update restrict;

alter table admin.user
   add constraint fk_user_ref_empl foreign key (id_employee)
      references journal.employee (id)
      on delete restrict on update restrict;

alter table admin.user
   add constraint fk_user_ref_role foreign key (id_role)
      references admin.role (id)
      on delete restrict on update restrict;