--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

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

DROP DATABASE IF EXISTS "InventarioVacunacionEmpleados";
--
-- Name: InventarioVacunacionEmpleados; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "InventarioVacunacionEmpleados" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Ecuador.1252';


ALTER DATABASE "InventarioVacunacionEmpleados" OWNER TO postgres;

\connect "InventarioVacunacionEmpleados"

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: empleado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.empleado (
    id integer NOT NULL,
    apellidos character varying(255),
    cedula character varying(255),
    correo character varying(255),
    direccion_domicilio character varying(255),
    fecha_nacimiento date,
    nombres character varying(255),
    telefono character varying(255),
    id_estadovacunacion integer,
    id_usuario integer
);


ALTER TABLE public.empleado OWNER TO postgres;

--
-- Name: empleado_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.empleado_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.empleado_id_seq OWNER TO postgres;

--
-- Name: empleado_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.empleado_id_seq OWNED BY public.empleado.id;


--
-- Name: empleadovacuna; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.empleadovacuna (
    id_empleadovacuna integer NOT NULL,
    fecha_vacunacion date,
    numero_dosis integer,
    id integer,
    id_tipovacuna integer
);


ALTER TABLE public.empleadovacuna OWNER TO postgres;

--
-- Name: empleadovacuna_id_empleadovacuna_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.empleadovacuna_id_empleadovacuna_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.empleadovacuna_id_empleadovacuna_seq OWNER TO postgres;

--
-- Name: empleadovacuna_id_empleadovacuna_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.empleadovacuna_id_empleadovacuna_seq OWNED BY public.empleadovacuna.id_empleadovacuna;


--
-- Name: estado_vacunacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estado_vacunacion (
    id_estado integer NOT NULL,
    nombre_estado character varying(255)
);


ALTER TABLE public.estado_vacunacion OWNER TO postgres;

--
-- Name: estado_vacunacion_id_estado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estado_vacunacion_id_estado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estado_vacunacion_id_estado_seq OWNER TO postgres;

--
-- Name: estado_vacunacion_id_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estado_vacunacion_id_estado_seq OWNED BY public.estado_vacunacion.id_estado;


--
-- Name: rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rol (
    id_rol integer NOT NULL,
    nombre_rol character varying(255)
);


ALTER TABLE public.rol OWNER TO postgres;

--
-- Name: rol_id_rol_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rol_id_rol_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rol_id_rol_seq OWNER TO postgres;

--
-- Name: rol_id_rol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.rol_id_rol_seq OWNED BY public.rol.id_rol;


--
-- Name: tipo_vacuna; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_vacuna (
    id_tipo integer NOT NULL,
    nombre_tipo character varying(255)
);


ALTER TABLE public.tipo_vacuna OWNER TO postgres;

--
-- Name: tipo_vacuna_id_tipo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_vacuna_id_tipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_vacuna_id_tipo_seq OWNER TO postgres;

--
-- Name: tipo_vacuna_id_tipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_vacuna_id_tipo_seq OWNED BY public.tipo_vacuna.id_tipo;


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id integer NOT NULL,
    estado boolean,
    password character varying(255),
    usuario character varying(255),
    id_rol integer
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_seq OWNER TO postgres;

--
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;


--
-- Name: empleado id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleado ALTER COLUMN id SET DEFAULT nextval('public.empleado_id_seq'::regclass);


--
-- Name: empleadovacuna id_empleadovacuna; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleadovacuna ALTER COLUMN id_empleadovacuna SET DEFAULT nextval('public.empleadovacuna_id_empleadovacuna_seq'::regclass);


--
-- Name: estado_vacunacion id_estado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado_vacunacion ALTER COLUMN id_estado SET DEFAULT nextval('public.estado_vacunacion_id_estado_seq'::regclass);


--
-- Name: rol id_rol; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol ALTER COLUMN id_rol SET DEFAULT nextval('public.rol_id_rol_seq'::regclass);


--
-- Name: tipo_vacuna id_tipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_vacuna ALTER COLUMN id_tipo SET DEFAULT nextval('public.tipo_vacuna_id_tipo_seq'::regclass);


--
-- Name: usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);


--
-- Data for Name: empleado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.empleado (id, apellidos, cedula, correo, direccion_domicilio, fecha_nacimiento, nombres, telefono, id_estadovacunacion, id_usuario) FROM stdin;
1	reyna	0850270133	rony1995@gmail.com	casa 1	1995-04-11	rony	0979375097	1	3
\.


--
-- Data for Name: empleadovacuna; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.empleadovacuna (id_empleadovacuna, fecha_vacunacion, numero_dosis, id, id_tipovacuna) FROM stdin;
1	2022-04-11	1	1	1
\.


--
-- Data for Name: estado_vacunacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estado_vacunacion (id_estado, nombre_estado) FROM stdin;
1	Vacunado
2	No Vacunado
\.


--
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rol (id_rol, nombre_rol) FROM stdin;
1	Administrador
2	Empleado
\.


--
-- Data for Name: tipo_vacuna; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_vacuna (id_tipo, nombre_tipo) FROM stdin;
2	AstraZeneca
3	Pfizer
4	Jhonson&Jhonson
1	Sputnik
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id, estado, password, usuario, id_rol) FROM stdin;
1	t	123456	rony	2
2	t	r0850270133	r0850270133	2
3	t	r0850270133	r0850270133	2
\.


--
-- Name: empleado_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.empleado_id_seq', 1, true);


--
-- Name: empleadovacuna_id_empleadovacuna_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.empleadovacuna_id_empleadovacuna_seq', 1, true);


--
-- Name: estado_vacunacion_id_estado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estado_vacunacion_id_estado_seq', 2, true);


--
-- Name: rol_id_rol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rol_id_rol_seq', 2, true);


--
-- Name: tipo_vacuna_id_tipo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_vacuna_id_tipo_seq', 5, true);


--
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_seq', 3, true);


--
-- Name: empleado empleado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (id);


--
-- Name: empleadovacuna empleadovacuna_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleadovacuna
    ADD CONSTRAINT empleadovacuna_pkey PRIMARY KEY (id_empleadovacuna);


--
-- Name: estado_vacunacion estado_vacunacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado_vacunacion
    ADD CONSTRAINT estado_vacunacion_pkey PRIMARY KEY (id_estado);


--
-- Name: rol rol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id_rol);


--
-- Name: tipo_vacuna tipo_vacuna_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_vacuna
    ADD CONSTRAINT tipo_vacuna_pkey PRIMARY KEY (id_tipo);


--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- Name: empleadovacuna fkfqave5rgygxkymkbp8jnaljx7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleadovacuna
    ADD CONSTRAINT fkfqave5rgygxkymkbp8jnaljx7 FOREIGN KEY (id) REFERENCES public.empleado(id);


--
-- Name: empleado fkkgtv1w3w5894ojvfp93kvom1v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT fkkgtv1w3w5894ojvfp93kvom1v FOREIGN KEY (id_estadovacunacion) REFERENCES public.estado_vacunacion(id_estado);


--
-- Name: usuario fkmyv3138vvci6kaq3y5kt4cntu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT fkmyv3138vvci6kaq3y5kt4cntu FOREIGN KEY (id_rol) REFERENCES public.rol(id_rol);


--
-- Name: empleadovacuna fko9twduo1s58v3s1xlim1o09l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleadovacuna
    ADD CONSTRAINT fko9twduo1s58v3s1xlim1o09l FOREIGN KEY (id_tipovacuna) REFERENCES public.tipo_vacuna(id_tipo);


--
-- Name: empleado fkt7vdal63o7rdoojoy7ywhjesh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT fkt7vdal63o7rdoojoy7ywhjesh FOREIGN KEY (id_usuario) REFERENCES public.usuario(id);


--
-- PostgreSQL database dump complete
--

