--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-03-30 22:16:29

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2827 (class 1262 OID 16537)
-- Name: CityDB; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "CityDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';


ALTER DATABASE "CityDB" OWNER TO postgres;

\connect "CityDB"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2821 (class 0 OID 16570)
-- Dependencies: 204
-- Data for Name: city; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.city (id, name, information) VALUES (1, 'Минск', 'Одна из главных достопримечательностей Минска – проспект Независимости, пролегающий от центра к северо-востоку. Его длина – 15 км. Это одна из самых протяженных городских магистралей в Европе. На проспекте расположены самые крупные площади Минска: площадь Независимости, Октябрьская площадь, Площадь Победы, площадь Якуба Коласа.');
INSERT INTO public.city (id, name, information) VALUES (2, 'Санкт-Петербург', 'Бывшая императорская загородная резиденция, которую основал Петр Великий в начале XVIII столетия. Этот грандиозный дворцово-парковый ансамбль называют «русским Версалем». За три столетия существования облик Петергофа достаточно сильно изменился, а после Войны 1941-1945 гг. его восстановили буквально из обломков. На территории комплекса располагаются десятки фонтанов, цветники, прогулочные аллеи и павильоны, которые напоминают об имперской эпохе российской истории.');
INSERT INTO public.city (id, name, information) VALUES (3, 'Киев', 'Родина-мать - популярное место в Киеве, представляющее собой грандиозный монумент-скульптуру, возведенный на правобережье Днепра в 1981 году. Памятник посвящен героям Великой Отечественной войны.');
INSERT INTO public.city (id, name, information) VALUES (4, 'Москва', 'Самые узнаваемые и посещаемые места в российской столице. Красные башни Кремля, увенчанные звездами – это устоявшийся бренд, символ Москвы. С XII столетия Кремль служил оборонительным сооружением, в течение веков он неоднократно горел и перестраивался. Красная площадь не раз становилась местом важных государственных событий. На ней проходили народные собрания, ярмарки, парады, разные культурные мероприятия.');
INSERT INTO public.city (id, name, information) VALUES (5, 'Бобруйск', 'Театр драмы и комедии им. Дунина-Марцинкевича в Бобруйске находится по улице Социалистической. Он занимает последнее место в рейтинге, так как само здание абсолютно ничем не примечательно. Оно не относится ни к старинным архитектурным сооружениям, ни к ультрамодным современным. Зато театр отлично вписывается в стилистику улицы согласно ее названия.');
INSERT INTO public.city (id, name, information) VALUES (6, 'Могилев', 'Архиерейский дворец выдающегося православного деятеля, ученого и просветителя, причисленного к лику святых Беларуси – Георгия Конисского – был возведен в 1762 – 1785 годах архитектором Яном Глаубицем. И до наших дней старинная резиденция остается украшением Могилева. Могилевский областной драматический театр – одно из красивейших зданий города. Построено в 1886-1888 годах по проекту архитектора П. Камбурова и инженера В. Мильяновского. Здание из красного кирпичас двумя «башенками» по углам.');


--
-- TOC entry 2829 (class 0 OID 0)
-- Dependencies: 203
-- Name: city_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.city_id_seq', 10, true);


--
-- TOC entry 2830 (class 0 OID 0)
-- Dependencies: 202
-- Name: id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.id', 1, false);


-- Completed on 2020-03-30 22:16:29

--
-- PostgreSQL database dump complete
--

