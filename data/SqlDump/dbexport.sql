--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2 (Debian 11.2-1.pgdg90+1)
-- Dumped by pg_dump version 11.2 (Debian 11.2-1.pgdg90+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: tbl_players; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.tbl_players (
    int_player_id bigint NOT NULL,
    int_age integer,
    str_player_name character varying(255),
    str_position character varying(255),
    str_player_surname character varying(255)
);


ALTER TABLE public.tbl_players OWNER TO root;

--
-- Name: tbl_players_int_player_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.tbl_players_int_player_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbl_players_int_player_id_seq OWNER TO root;

--
-- Name: tbl_players_int_player_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.tbl_players_int_player_id_seq OWNED BY public.tbl_players.int_player_id;


--
-- Name: tbl_team_squads; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.tbl_team_squads (
    int_team_squad_id bigint NOT NULL,
    int_year integer,
    int_player_id bigint NOT NULL,
    int_team_id bigint NOT NULL
);


ALTER TABLE public.tbl_team_squads OWNER TO root;

--
-- Name: tbl_team_squads_int_team_squad_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.tbl_team_squads_int_team_squad_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbl_team_squads_int_team_squad_id_seq OWNER TO root;

--
-- Name: tbl_team_squads_int_team_squad_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.tbl_team_squads_int_team_squad_id_seq OWNED BY public.tbl_team_squads.int_team_squad_id;


--
-- Name: tbl_teams; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.tbl_teams (
    int_team_id bigint NOT NULL,
    str_league_name character varying(255),
    str_team_name character varying(255)
);


ALTER TABLE public.tbl_teams OWNER TO root;

--
-- Name: tbl_teams_int_team_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.tbl_teams_int_team_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbl_teams_int_team_id_seq OWNER TO root;

--
-- Name: tbl_teams_int_team_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.tbl_teams_int_team_id_seq OWNED BY public.tbl_teams.int_team_id;


--
-- Name: tbl_players int_player_id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tbl_players ALTER COLUMN int_player_id SET DEFAULT nextval('public.tbl_players_int_player_id_seq'::regclass);


--
-- Name: tbl_team_squads int_team_squad_id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tbl_team_squads ALTER COLUMN int_team_squad_id SET DEFAULT nextval('public.tbl_team_squads_int_team_squad_id_seq'::regclass);


--
-- Name: tbl_teams int_team_id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tbl_teams ALTER COLUMN int_team_id SET DEFAULT nextval('public.tbl_teams_int_team_id_seq'::regclass);


--
-- Data for Name: tbl_players; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.tbl_players (int_player_id, int_age, str_player_name, str_position, str_player_surname) FROM stdin;
1	26	Atıl	CMD	Vural
2	26	Berk	ST	Mertoglu
\.


--
-- Data for Name: tbl_team_squads; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.tbl_team_squads (int_team_squad_id, int_year, int_player_id, int_team_id) FROM stdin;
1	2018	1	1
2	2017	1	1
3	2016	1	1
4	2018	2	1
5	2017	2	2
\.


--
-- Data for Name: tbl_teams; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.tbl_teams (int_team_id, str_league_name, str_team_name) FROM stdin;
1	TSL	FB
2	TSL	GS
\.


--
-- Name: tbl_players_int_player_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.tbl_players_int_player_id_seq', 2, true);


--
-- Name: tbl_team_squads_int_team_squad_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.tbl_team_squads_int_team_squad_id_seq', 5, true);


--
-- Name: tbl_teams_int_team_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.tbl_teams_int_team_id_seq', 2, true);


--
-- Name: tbl_players tbl_players_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tbl_players
    ADD CONSTRAINT tbl_players_pkey PRIMARY KEY (int_player_id);


--
-- Name: tbl_team_squads tbl_team_squads_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tbl_team_squads
    ADD CONSTRAINT tbl_team_squads_pkey PRIMARY KEY (int_team_squad_id);


--
-- Name: tbl_teams tbl_teams_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tbl_teams
    ADD CONSTRAINT tbl_teams_pkey PRIMARY KEY (int_team_id);


--
-- Name: tbl_teams uk72ryuk26limm415unb6m3nl40; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tbl_teams
    ADD CONSTRAINT uk72ryuk26limm415unb6m3nl40 UNIQUE (str_team_name, str_league_name);


--
-- Name: tbl_players ukea0qenaq3jgstix2jeeps3l8t; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tbl_players
    ADD CONSTRAINT ukea0qenaq3jgstix2jeeps3l8t UNIQUE (str_player_name, str_player_surname);


--
-- Name: tbl_team_squads uktcxud66wtihwqtt406ka9ut1d; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tbl_team_squads
    ADD CONSTRAINT uktcxud66wtihwqtt406ka9ut1d UNIQUE (int_year, int_player_id);


--
-- Name: tbl_team_squads fkamk0e91cvln1tsn0u57abqx6l; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tbl_team_squads
    ADD CONSTRAINT fkamk0e91cvln1tsn0u57abqx6l FOREIGN KEY (int_player_id) REFERENCES public.tbl_players(int_player_id);


--
-- Name: tbl_team_squads fkql7jc5l7p09y57kp89lmeyiay; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tbl_team_squads
    ADD CONSTRAINT fkql7jc5l7p09y57kp89lmeyiay FOREIGN KEY (int_team_id) REFERENCES public.tbl_teams(int_team_id);


--
-- PostgreSQL database dump complete
--

