INSERT INTO public.MOVIE (ID,TITLE) VALUES (1,'Film6');
INSERT INTO public.MOVIE (ID,TITLE) VALUES (2,'Film4');
INSERT INTO public.MOVIE (ID,TITLE) VALUES (3,'Film3');
INSERT INTO public.MOVIE (ID,TITLE) VALUES (4,'Film9');
INSERT INTO public.MOVIE (ID,TITLE) VALUES (5,'Film5');
INSERT INTO public.MOVIE (ID,TITLE) VALUES (6,'Film2');
INSERT INTO public.MOVIE (ID,TITLE) VALUES (7,'Film1');
INSERT INTO public.MOVIE (ID,TITLE) VALUES (8,'Film7');
INSERT INTO public.MOVIE (ID,TITLE) VALUES (9,'Film8');

INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (1,1,{ts '2019-11-10 10:00:00'},1);
INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (2,1,{ts '2019-11-10 12:00:00'},1);
INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (3,1,{ts '2019-11-12 14:00:00'},2);
INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (4,1,{ts '2019-11-12 16:00:00'},2);
INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (5,1,{ts '2019-11-13 18:00:00'},2);
INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (6,1,{ts '2019-11-13 20:00:00'},3);
INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (7,2,{ts '2019-11-14 14:00:00'},3);
INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (8,2,{ts '2019-11-14 16:00:00'},4);
INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (9,2,{ts '2019-11-15 18:00:00'},5);
INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (10,2,{ts '2019-11-15 20:00:00'},6);
INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (11,2,{ts '2019-11-16 10:00:00'},7);
INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (12,2,{ts '2019-11-16 12:00:00'},8);
INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (13,3,{ts '2019-11-17 18:00:00'},8);
INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (14,3,{ts '2019-11-17 20:00:00'},8);
INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (15,3,{ts '2019-11-18 10:00:00'},8);
INSERT INTO public.SCREEN_TIMES (ID,SCREEN_ROOM_ID,SCREEN_TIME,MOVIE_ID) VALUES (16,3,{ts '2019-11-18 12:00:00'},9);

INSERT INTO public.SCREEN_ROOM (ID,ROW_NUMBER,SEAT_NUMBER_IN_ROW) VALUES (1,3,5);
INSERT INTO public.SCREEN_ROOM (ID,ROW_NUMBER,SEAT_NUMBER_IN_ROW) VALUES (2,5,5);
INSERT INTO public.SCREEN_ROOM (ID,ROW_NUMBER,SEAT_NUMBER_IN_ROW) VALUES (3,7,5);