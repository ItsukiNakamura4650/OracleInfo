drop table memo;

--VARCHAR2(10)は半角英数字10文字入るがひらがなや漢字だとまた別になってくる
--詳細はhttps://searchman.info/tips/2660.htmlを読むこと
create table memo(
idx number not null primary key,
writer varchar2(150) not null,
purpose varchar2(150) not null,
location varchar2(150) not null,
attendee varchar2(150) not null,
memo varchar2(300) not null,
conclusion varchar2(150) not null,
post_date date default sysdate
);

-- 過去バージョンのoracleではauto_incrementが使えないため下記の方法で採番する
select max(idx)+1 from memo;
select nvl(max(idx)+1,1)from memo;

insert into memo(idx, writer, purpose, location, attendee, memo, conclusion) values(
    (select nvl(max(idx)+1,1) from memo),
    '木村哲也',
    '◯◯商品開発の決定について',
    '◯◯会議室',
    '◯◯部長、◯◯課長',
    '◯◯部長より予算の関係上、サンプル配布は難しいとのこと(◯◯係長)',
    'ネーミングは◯◯に決定する'
);

insert into memo(idx, writer, purpose, location, attendee, memo, conclusion) values(
    (select nvl(max(idx)+1,1) from memo),
    '小川祐介',
    '新規顧客獲得の施策について',
    '◯◯会議室',
    '◯◯係長、◯◯主任',
    '価格設定は◯◯を予定（◯◯主任）',
    '実演販売ができるように担当役員に提言する'
);

insert into memo(idx, writer, purpose, location, attendee, memo, conclusion) values(
    (select nvl(max(idx)+1,1) from memo),
    '高橋沙織',
    '来期重点目標決定の件',
    '本社会議室B',
    '営業企画部　大道課長、田中係長',
    '新規顧客獲得の施策について',
    'Facebookアカウントの開設と投稿'
);

insert into memo(idx, writer, purpose, location, attendee, memo, conclusion) values(
    (select nvl(max(idx)+1,1) from memo),
    '伊藤麻衣子',
    '新規マーケット（東海地区）開拓の件',
    '株式会社インソース商事本社６Ｆ会議室',
    '営業部　金本部長、赤星課長、檜山',
    '売り上げ見込み自動計算機能の追加開発のご要望',
    'オンラインセミナーの開催'
);

insert into memo(idx, writer, purpose, location, attendee, memo, conclusion) values(
    (select nvl(max(idx)+1,1) from memo),
    '小林由香',
    '顧客管理システム機能追加に関する会議議事録',
    '◯◯会議室にて',
    '営業企画部　大道課長、田中係長、柴田',
    '価格設定は◯◯を予定（◯◯主任）',
    'ＷＥＢセキュリティ対策として、アクセス制限機能を追加する。'
);

select * from memo;