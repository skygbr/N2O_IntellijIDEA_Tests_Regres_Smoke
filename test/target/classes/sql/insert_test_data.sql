-- Конфиг для добавления записей в таблицу pim_individual
select set_config('app.source', 'AUTOTEST', false);

-- Стационар. Шаблоны услуг.
-- insert into pim_party (id, type_id) values (nextval('pim_party_id_seq'), 2);
-- insert into pim_organization (id, full_name, short_name) values (currval('pim_party_id_seq'), 'Стационар для автотестов', 'Стационар для автотестов');

insert into sr_service(name, org_id, type_id, from_dt, to_dt) values('Услуга для тестирования шаблонов услуг',
 (select id from pim_organization where short_name='Стационар для автотестов' limit 1), (select id from sr_srv_type limit 1), '2015-06-30', '2015-07-10');

insert into pim_department(id, name, org_id, type_id) values(nextval('dc_departament_seq'), 'Клиническое отделение автотесты стационар',
 (select id from pim_organization where short_name='Стационар для автотестов' limit 1), 3);

insert into sr_res_group(id, name, org_id, is_system) values(nextval('sr_res_group_seq'), 'Сост.ресурс для автотестов стационар',
(select id from pim_organization where short_name='Стационар для автотестов' limit 1), FALSE);

insert into md_profile(id, code, name) values (nextval('md_profile_seq'), 'autotest', 'Профиль для стационара автотест');
insert into md_clinic_to_profile(clinic_id, profile_id) values ((select id from pim_organization where short_name='Стационар для автотестов' limit 1),
(select id from md_profile where code='autotest' limit 1));

--insert into pim_speciality(code, name) values ('autotest', 'Специальность для автотеста');

insert into md_clinic_separation(id, name, clinic_id) values (nextval('md_clinic_separation_seq'), 'Разбивка для Стационара автотест', (select id from pim_organization where short_name='Стационар для автотестов' limit 1));

insert into md_clinic_district(id, name, separation_id, order_number, code) values (nextval('md_clinic_district_seq'),
'Участок для Стационара автотест',
(select id from md_clinic_separation where name='Разбивка для Стационара автотест' limit 1),
(select id from pim_organization where short_name='Стационар для автотестов' limit 1), 'autotest'
 );


--Стационар. История болезни. Услуги. По шаблону
insert into services_template(id, clinic_id, name, is_service, is_holding) values(nextval('services_template_seq'), (select id from pim_organization where short_name='Стационар для автотестов' limit 1), 'Шаблон 1 автотест', true, false);

insert into sr_srv_prototype (id, code, is_independent, name, is_remote, type_id, anesthesia_type, is_repeated, is_expendable_materials, is_complete_protocol, is_complex, accounting_id)
values (nextval('sr_srv_prototype_id_seq'),'1 автотест', true, 'Услуга шаблона 1 автотест', false, 0, false, false, false, false, false, 1);
insert into md_prescription(id, prototype_id) values (nextval('md_prescription_seq'), currval('sr_srv_prototype_id_seq'));
insert into md_standard_prescription(id, standard_id, is_actual) values(currval('md_prescription_seq'), (select id from md_standard where (name = 'Стандарт для автотестов (не трогать)')), true);
insert into sr_service(name, org_id, type_id, from_dt, to_dt, prototype_id) values('Услуга шаблона 1 автотест',
  (select id from pim_organization where short_name='Стационар для автотестов' limit 1), (select id from sr_srv_type limit 1), '2015-06-30', '2015-07-10', currval('sr_srv_prototype_id_seq'));

insert into sr_srv_prototype (id, code, is_independent, name, is_remote, type_id, anesthesia_type, is_repeated, is_expendable_materials, is_complete_protocol, is_complex, accounting_id)
values (nextval('sr_srv_prototype_id_seq'),'2 автотест', true, 'Услуга шаблона 2 автотест', false, 0, false, false, false, false, false, 1);
insert into md_prescription(id, prototype_id) values (nextval('md_prescription_seq'), currval('sr_srv_prototype_id_seq'));
insert into md_standard_prescription(id, standard_id, is_actual) values(currval('md_prescription_seq'), (select id from md_standard where (name = 'Стандарт для автотестов (не трогать)')), true);
insert into sr_service(name, org_id, type_id, from_dt, to_dt, prototype_id) values('Услуга шаблона 2 автотест',
  (select id from pim_organization where short_name='Стационар для автотестов' limit 1), (select id from sr_srv_type limit 1), '2015-06-30', '2015-07-10', currval('sr_srv_prototype_id_seq'));

insert into sr_srv_prototype (id, code, is_independent, name, is_remote, type_id, anesthesia_type, is_repeated, is_expendable_materials, is_complete_protocol, is_complex, accounting_id)
values (nextval('sr_srv_prototype_id_seq'),'3 автотест', true, 'Услуга шаблона 3 автотест', false, 0, false, false, false, false, false, 1);
insert into md_prescription(id, prototype_id) values (nextval('md_prescription_seq'), currval('sr_srv_prototype_id_seq'));
insert into md_standard_prescription(id, standard_id, is_actual) values(currval('md_prescription_seq'), (select id from md_standard where (name = 'Стандарт для автотестов (не трогать)')), true);
insert into sr_service(name, org_id, type_id, from_dt, to_dt, prototype_id) values('Услуга шаблона 3 автотест',
  (select id from pim_organization where short_name='Стационар для автотестов' limit 1), (select id from sr_srv_type limit 1), '2015-06-30', '2015-07-10', currval('sr_srv_prototype_id_seq'));

insert into services_template_service(id, template_id, service_id, schedule_selection_type_id) values (nextval('services_template_service_seq'),
  (select id from services_template where name = 'Шаблон 1 автотест' limit 1), (select id from sr_service where name = 'Услуга шаблона 1 автотест' limit 1),1);
insert into services_template_service(id, template_id, service_id, schedule_selection_type_id) values (nextval('services_template_service_seq'),
  (select id from services_template where name = 'Шаблон 1 автотест' limit 1), (select id from sr_service where name = 'Услуга шаблона 2 автотест' limit 1),1);
insert into services_template_service(id, template_id, service_id, schedule_selection_type_id) values (nextval('services_template_service_seq'),
  (select id from services_template where name = 'Шаблон 1 автотест' limit 1), (select id from sr_service where name = 'Услуга шаблона 3 автотест' limit 1),1);

--Стационар. Роли сотрудников.
--Врач для стационара
insert into pim_party (id, type_id, note) values (nextval('pim_party_id_seq'), 1, 'Врач для автотеста стационара');

insert into pim_individual (id, birth_dt, name, patr_name, surname, gender_id)
values (currval('pim_party_id_seq'), '1991-01-01', 'Автотест', 'Автотестович', 'Автотестов', 1);

insert into pim_employee (id, individual_id, organization_id, note) values
(nextval('pim_employee_id_seq'), currval('pim_party_id_seq'), (select id from pim_organization where short_name='Стационар для автотестов' limit 1), 'Врач для автотестов стационара');

insert into pim_position_role(id, code, name, category_id) values(nextval('pim_position_role_seq'), 'autotest', 'Врач автотест', (select id from pim_position_category where code = '1'));

insert into pim_position (id, name, department_id, organization_id, role_id, rate)
values (nextval('pim_position_id_seq'), 'Врач-автотест', (select id from pim_department where name = 'Отделение экстренной госпитализации' limit 1), (select id from pim_organization where short_name='Стационар для автотестов' limit 1), currval('pim_position_role_seq'), 1);

insert into pim_employee_position (id, start_date, employee_id, position_id, code)
values (nextval('pim_employee_to_position_seq'), now(), currval('pim_employee_id_seq'), currval('pim_position_id_seq'), 'autotestHs');

insert into md_employee_position (id) values ((select id from pim_employee_position where code = 'autotestHs' limit 1));

--Врач № 2
insert into pim_party (id, type_id, note) values (nextval('pim_party_id_seq'), 1, 'Врач для автотеста стационара 2');

insert into pim_individual (id, birth_dt, name, patr_name, surname, gender_id)
values (currval('pim_party_id_seq'), '1991-01-01', 'Автотест2', 'Автотестович2', 'Автотестов2', 1);

insert into pim_employee (id, individual_id, organization_id, note) values
(nextval('pim_employee_id_seq'), currval('pim_party_id_seq'), (select id from pim_organization where short_name='Стационар для автотестов' limit 1), 'Врач для автотестов стационара 2');

insert into pim_employee_position (id, start_date, employee_id, position_id, code)
values (nextval('pim_employee_to_position_seq'), now(), currval('pim_employee_id_seq'),
(select id from pim_position where name = 'Врач-автотест' limit 1), 'autotest2');

insert into md_employee_position (id) values ((select id from pim_employee_position where code = 'autotest2' limit 1));

--Услуги
insert into sr_service(name, org_id, type_id) values('Услуга для автотеста стационара 1',
 (select id from pim_organization where short_name='Стационар для автотестов' limit 1), (select id from sr_srv_type limit 1));
insert into sr_service(name, org_id, type_id) values('Услуга для автотеста стационара 2',
 (select id from pim_organization where short_name='Стационар для автотестов' limit 1), (select id from sr_srv_type limit 1));

 --Обеспечение
  insert into pim_party (id, type_id) values (nextval('pim_party_id_seq'), 2);
insert into pim_organization (id, full_name, short_name,reg_dt) values (currval('pim_party_id_seq'),'МО для автотестов Обеспечения',
'МО для автотестов Обеспечения','01-01-2015');
insert into md_clinic (id,code, full_name, short_name,reg_dt) values (currval('pim_party_id_seq'),
'11111111' ,'МО для автотестов Обеспечения', 'МО для автотестов Обеспечения','01-01-2015');
insert into sec.role (id,name) values (nextval('sec.role_id_seq'),'Роль для тестов Обеспечения');
insert into sec.role_org(id,org_id) values ((select id from sec.role where name='Роль для тестов Обеспечения'),
(select id from pim_organization where short_name='МО для автотестов Обеспечения'));
insert into sec.access_key(type_id,org_id,user_id,name) values((select distinct 2 as type_id),
(select id from pim_organization where short_name='МО для автотестов Обеспечения'),
(select id from sec_user where login ='autotest_acceptance'),'Ключ доступа для автотестов Обеспечения');
insert into sec.access_key_role(role_id,user_access_id) values ((select id from sec.role where name='Роль для тестов Обеспечения'),
(select id from sec.access_key where name='Ключ доступа для автотестов Обеспечения'));
insert into sec.permission_ref(section_id,element_id,permission_id,allowed,role_id) values('domainObjects','administrativeData','updateAdministrData',true,
(select id from sec.role where name='Роль для тестов Обеспечения'));
insert into sec.permission_ref(section_id,element_id,permission_id,allowed,role_id) values('domainObjects','administrativeData','readAdministrData',true,
(select id from sec.role where name='Роль для тестов Обеспечения'));

 --Медицинские организации
insert into sec.role (id,name) values (nextval('sec.role_id_seq'),'Роль для тестов Медицинские организации');
insert into sec.access_key(type_id,user_id,name) values((select distinct 2 as type_id),
(select id from sec_user where login ='autotest_acceptance'),'Ключ доступа для автотестов Медицинские организации');
insert into sec.access_key_role(role_id,user_access_id) values ((select id from sec.role where name='Роль для тестов Медицинские организации'),
(select id from sec.access_key where name='Ключ доступа для автотестов Медицинские организации'));
insert into sec.permission_ref(section_id,element_id,permission_id,allowed,role_id) values('domainObjects','organizationsList','updateOrganizationsList',true,
(select id from sec.role where name='Роль для тестов Медицинские организации'));
insert into sec.permission_ref(section_id,element_id,permission_id,allowed,role_id) values('domainObjects','organizationsList','readOrganizationsList',true,
(select id from sec.role where name='Роль для тестов Медицинские организации'));



