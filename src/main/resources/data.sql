insert into question(content)
values
('당신은 책을 통해 어떤 것을 얻고 싶나요?'),
('나는 책을 읽을 때'),
('책이나 영화, 드라마를 보고 나서'),
('나는 책을 고를 때');

insert into answer(question_id, content)
values
(1, '내가 몰랐던 흥미로운 정보를 얻고 싶다.'),
(1, '책 속 인물들의 이야기와 감정을 통해 새로운 세계를 경험하고 싶다.'),
(2, '현실성 넘치는 책이 더 몰입되는 것 같다.'),
(2, '상상도 해본 적 없는 미지의 세계로 가고 싶다.'),
(3, '한번 과몰입하면 헤어나오기 어렵다.'),
(3, '책은 책이고 나는 나.'),
(4, '클래식 이즈 더 베스트. 오랫동안 사랑받은 고전은 그만한 가치가 있겠지.'),
(4, '명성보다는 느낌. 남들은 모르고 나만 아는 비밀의 책 발굴하는 기분도 좋다.');


insert into book(title, page_url, image_url, author, isbn)
values
('해리포터 혼혈왕자 1: 슬리데린(기숙사 에디션)', 'https://search.shopping.naver.com/book/catalog/40709070618', 'https://shopping-phinf.pstatic.net/main_4070907/40709070618.20230926084731.jpg', '조앤 K. 롤링', '9791192776507'),
('해리 포터와 마법사의 돌 1 (해리포터 20주년 개정판)', 'https://search.shopping.naver.com/book/catalog/32473349454', 'https://shopping-phinf.pstatic.net/main_3247334/32473349454.20230927071208.jpg', '조앤 K. 롤링', '9788983927620'),
('해리 포터와 마법사의 돌 2 (해리포터 20주년 개정판)', 'https://search.shopping.naver.com/book/catalog/32457431795', 'https://shopping-phinf.pstatic.net/main_3245743/32457431795.20230927071333.jpg', '조앤 K. 롤링', '9788983927637'),
('해리포터: 죽음의 성물 4 (개정판)', 'https://search.shopping.naver.com/book/catalog/32441513924', 'https://shopping-phinf.pstatic.net/main_3244151/32441513924.20220527051448.jpg', 'J.K. 롤링', '9788983925534'),
('트렌드 코리아 2024 (2024 대한민국 소비트렌드 전망)', 'https://search.shopping.naver.com/book/catalog/42571495636', 'https://shopping-phinf.pstatic.net/main_4257149/42571495636.20231003084746.jpg', '김난도^전미영^최지혜^이수진^권정윤^한다혜^이준영^이향은^이혜원^추예린^전다현', '9788959897179'),
('트렌드 코리아 2023 (서울대 소비트렌드 분석센터의 2023 전망)', 'https://search.shopping.naver.com/book/catalog/34774839621', 'https://shopping-phinf.pstatic.net/main_3477483/34774839621.20221017171955.jpg', '김난도^전미영^최지혜^이수진^권정윤^이준영^이향은^한다혜^이혜원^추예린', '9788959897094');
