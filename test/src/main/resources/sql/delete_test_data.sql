-- Конфиг для добавления записей в таблицу pim_individual
select set_config('app.source', 'AUTOTEST', false);

-- Стационар. Шаблоны услуг.
delete from services_template where name in ('Шаблон для автотестов (обновление)', 'Шаблон для автотестов');
delete from sr_service where name = 'Услуга для тестирования шаблонов услуг';
delete from pim_department where name = 'Клиническое отделение автотесты стационар';
delete from sr_res_group where name = 'Сост.ресурс для автотестов стационар';
delete from md_clinic_to_profile where profile_id in (select id from md_profile where code = 'autotest');
delete from md_profile where code = 'autotest';
--delete from pim_speciality where code = 'autotest';
delete from md_clinic_separation where name = 'Разбивка для Стационара автотест';

--Стационар. История болезни. Услуги. По шаблону
delete from services_template_service where service_id in
 (select id from sr_service where name in ('Услуга шаблона 1 автотест','Услуга шаблона 2 автотест','Услуга шаблона 3 автотест'));
delete from sr_service where name = 'Услуга шаблона 1 автотест';
delete from sr_service where name = 'Услуга шаблона 2 автотест';
delete from sr_service where name = 'Услуга шаблона 3 автотест';
delete from sr_srv_prototype where name = 'Услуга шаблона 1 автотест';
delete from sr_srv_prototype where name = 'Услуга шаблона 2 автотест';
delete from sr_srv_prototype where name = 'Услуга шаблона 3 автотест';
delete from services_template where name = 'Шаблон 1 автотест';

delete from sr_srv_rendered where service_id in
 (select id from sr_service where name in ('Услуга шаблона 1 автотест','Услуга шаблона 2 автотест','Услуга шаблона 3 автотест'));

--Стационар. Роли сотрудников.
delete from sr_resource where id in (select id from pim_employee_position_resource where employee_position_id in (select id from pim_employee_position where code = 'autotest2'));
delete from pim_employee_position_resource where employee_position_id in (select id from pim_employee_position where code = 'autotest2');
delete from pim_employee_position where code = 'autotestHs2';
delete from pim_employee where individual_id in (select id from pim_individual where name = 'Автотест2' and surname = 'Автотестов2' and patr_name = 'Автотестович2' and birth_dt = '1991-01-01');
delete from pim_individual where name = 'Автотест2' and surname = 'Автотестов2' and patr_name = 'Автотестович2' and birth_dt = '1991-01-01';
delete from pim_party where note = 'Врач для автотеста стационара 2';

delete from sr_resource where id in (select id from pim_employee_position_resource where employee_position_id in (select id from pim_employee_position where code = 'autotestHs'));
delete from pim_employee_position_resource where employee_position_id in (select id from pim_employee_position where code = 'autotestHs');
delete from pim_employee_position where code = 'autotestHs';
delete from pim_employee where individual_id in (select id from pim_individual where name = 'Автотест' and surname = 'Автотестов' and patr_name = 'Автотестович' and birth_dt = '1991-01-01');
delete from pim_individual where name = 'Автотест' and surname = 'Автотестов' and patr_name = 'Автотестович' and birth_dt = '1991-01-01';
delete from pim_position where name = 'Врач-автотест';
delete from pim_position_role where code = 'autotest' and name = 'Врач автотест';
delete from pim_party where note = 'Врач для автотеста стационара';

delete from sr_service where name in ('Услуга для автотеста стационара 1','Услуга для автотеста стационара 2');

--Обеспечение
delete   from pim_organization_account where check_acc_id in (
select id from pim_bank_details where org_id in (select id from  pim_organization where short_name= 'МО для автотестов Обеспечения2'));
delete from pim_bank_details where org_id in (select id from  pim_organization where short_name= 'МО для автотестов Обеспечения2');
delete from  sec.access_key where name='Ключ доступа для автотестов Обеспечения';
delete from  sec.role_org where id in (select id from sec.role where name='Роль для тестов Обеспечения');
delete from  pim_organization where short_name= 'МО для автотестов Обеспечения';
delete from  pim_organization where short_name= 'МО для автотестов Обеспечения2';
delete from  sec.role where name='Роль для тестов Обеспечения';

--Медицинские организации
delete from  sec.access_key where name='Ключ доступа для автотестов Медицинские организации';
delete from  sec.role_org where id in (select id from sec.role where name='Роль для тестов Медицинские организации');
delete from  sec.role where name='Роль для тестов Медицинские организации';

