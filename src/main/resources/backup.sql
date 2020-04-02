--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-04-02 13:05:14

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
-- TOC entry 2825 (class 1262 OID 16537)
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

SET default_table_access_method = heap;

--
-- TOC entry 204 (class 1259 OID 16570)
-- Name: city; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.city (
    id bigint NOT NULL,
    name character varying(20) NOT NULL,
    information character varying(500) NOT NULL
);


ALTER TABLE public.city OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16568)
-- Name: city_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.city_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.city_id_seq OWNER TO postgres;

--
-- TOC entry 2826 (class 0 OID 0)
-- Dependencies: 203
-- Name: city_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.city_id_seq OWNED BY public.city.id;


--
-- TOC entry 2689 (class 2604 OID 16573)
-- Name: city id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.city ALTER COLUMN id SET DEFAULT nextval('public.city_id_seq'::regclass);


--
-- TOC entry 2819 (class 0 OID 16570)
-- Dependencies: 204
-- Data for Name: city; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.city (id, name, information) VALUES (1, 'минск', 'Одна из главных достопримечательностей Минска – проспект Независимости, пролегающий от центра к северо-востоку. Его длина – 15 км. Это одна из самых протяженных городских магистралей в Европе. На проспекте расположены самые крупные площади Минска: площадь Независимости, Октябрьская площадь, Площадь Победы, площадь Якуба Коласа.');
INSERT INTO public.city (id, name, information) VALUES (2, 'санкт-петербург', 'Бывшая императорская загородная резиденция, которую основал Петр Великий в начале XVIII столетия. Этот грандиозный дворцово-парковый ансамбль называют «русским Версалем». За три столетия существования облик Петергофа достаточно сильно изменился, а после Войны 1941-1945 гг. его восстановили буквально из обломков. На территории комплекса располагаются десятки фонтанов, цветники, прогулочные аллеи и павильоны, которые напоминают об имперской эпохе российской истории.');
INSERT INTO public.city (id, name, information) VALUES (3, 'киев', 'Родина-мать - популярное место в Киеве, представляющее собой грандиозный монумент-скульптуру, возведенный на правобережье Днепра в 1981 году. Памятник посвящен героям Великой Отечественной войны.');
INSERT INTO public.city (id, name, information) VALUES (4, 'москва', 'Самые узнаваемые и посещаемые места в российской столице. Красные башни Кремля, увенчанные звездами – это устоявшийся бренд, символ Москвы. С XII столетия Кремль служил оборонительным сооружением, в течение веков он неоднократно горел и перестраивался. Красная площадь не раз становилась местом важных государственных событий. На ней проходили народные собрания, ярмарки, парады, разные культурные мероприятия.');
INSERT INTO public.city (id, name, information) VALUES (5, 'бобруйск', 'Театр драмы и комедии им. Дунина-Марцинкевича в Бобруйске находится по улице Социалистической. Он занимает последнее место в рейтинге, так как само здание абсолютно ничем не примечательно. Оно не относится ни к старинным архитектурным сооружениям, ни к ультрамодным современным. Зато театр отлично вписывается в стилистику улицы согласно ее названия.');
INSERT INTO public.city (id, name, information) VALUES (6, 'могилев', 'Архиерейский дворец выдающегося православного деятеля, ученого и просветителя, причисленного к лику святых Беларуси – Георгия Конисского – был возведен в 1762 – 1785 годах архитектором Яном Глаубицем. И до наших дней старинная резиденция остается украшением Могилева. Могилевский областной драматический театр – одно из красивейших зданий города. Построено в 1886-1888 годах по проекту архитектора П. Камбурова и инженера В. Мильяновского. Здание из красного кирпичас двумя «башенками» по углам.');
INSERT INTO public.city (id, name, information) VALUES (7, 'варшава', 'Дворцовая площадь Варшавы является одним из красивейших мест в Польше. Здесь можно ощутить все величие столицы и проникнуться ее неповторимой сказочной атмосферой. Вдоль восточной стороны площади построен великолепный Королевский замок. Это место - важная историческая, архитектурная и культурная достопримечательность Варшавы.');
INSERT INTO public.city (id, name, information) VALUES (8, 'лондон', 'Если ваша поездка в Лондон связана с желанием познакомиться с уникальными архитектурными памятниками, совершите путешествие в центр города к этому величественному собору. Внушительные габариты делают храм св. Петра, выполненный в стилях барокко и ренессанс, одним из крупнейших в Европе и мире. Дата строительства – 7 столетие. Огромный интерес вызывает купол здания, облицованный свинцовыми плитами.');


--
-- TOC entry 2827 (class 0 OID 0)
-- Dependencies: 203
-- Name: city_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.city_id_seq', 14, true);


--
-- TOC entry 2691 (class 2606 OID 16578)
-- Name: city city_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.city
    ADD CONSTRAINT city_id_key UNIQUE (id);


-- Completed on 2020-04-02 13:05:14

--
-- PostgreSQL database dump complete
--

