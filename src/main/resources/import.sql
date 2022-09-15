use plovo;

select * from mountain;
insert into mountain(distance, m_name, main_img, map_img) values('582m', '광교산', 'https://plovo.s3.ap-northeast-2.amazonaws.com/mountain/%EA%B4%91%EA%B5%90%EC%82%B0.jfif', 'https://plovo.s3.ap-northeast-2.amazonaws.com/mountain/%EA%B4%91%EA%B5%90%EC%82%B0+%EC%A7%80%EB%8F%84.PNG');
insert into mountain(distance, m_name, main_img, map_img) values('489m', '수리산', 'https://plovo.s3.ap-northeast-2.amazonaws.com/mountain/%EC%88%98%EB%A6%AC%EC%82%B0.png', 'https://plovo.s3.ap-northeast-2.amazonaws.com/mountain/%EC%88%98%EB%A6%AC%EC%82%B0+%EC%A7%80%EB%8F%84.png');
insert into mountain(distance, m_name, main_img, map_img) values('470m', '불곡산', 'https://plovo.s3.ap-northeast-2.amazonaws.com/mountain/%EB%B6%88%EA%B3%A1%EC%82%B0.png', 'https://plovo.s3.ap-northeast-2.amazonaws.com/mountain/%EB%B6%88%EA%B3%A1%EC%82%B0+%EC%A7%80%EB%8F%84.png');
insert into mountain(distance, m_name, main_img, map_img) values('810m', '천마산', 'https://plovo.s3.ap-northeast-2.amazonaws.com/mountain/%EC%B2%9C%EB%A7%88%EC%82%B0.png', 'https://plovo.s3.ap-northeast-2.amazonaws.com/mountain/%EC%B2%9C%EB%A7%88%EC%82%B0+%EC%A7%80%EB%8F%84.png');
insert into mountain(distance, m_name, main_img, map_img) values('661m', '도덕산', 'https://plovo.s3.ap-northeast-2.amazonaws.com/mountain/%EB%8F%84%EB%8D%95%EC%82%B0.png', 'https://plovo.s3.ap-northeast-2.amazonaws.com/mountain/%EB%8F%84%EB%8D%95%EC%82%B0+%EC%A7%80%EB%8F%84.png');

select * from plovo;
insert into plovo(current_weight, img, weight, mountain_id) values('0', 'https://plovo.s3.ap-northeast-2.amazonaws.com/mountain/%EA%B4%91%EA%B5%90%EC%82%B0.jfif', '0', 1);
insert into plovo(current_weight, img, weight, mountain_id) values('0', 'https://plovo.s3.ap-northeast-2.amazonaws.com/mountain/%EC%88%98%EB%A6%AC%EC%82%B0.png', '0', 2);
insert into plovo(current_weight, img, weight, mountain_id) values('0', 'https://plovo.s3.ap-northeast-2.amazonaws.com/mountain/%EB%B6%88%EA%B3%A1%EC%82%B0.png', '0', 3);
insert into plovo(current_weight, img, weight, mountain_id) values('0', 'https://plovo.s3.ap-northeast-2.amazonaws.com/mountain/%EC%B2%9C%EB%A7%88%EC%82%B0.png', '0', 4);
insert into plovo(current_weight, img, weight, mountain_id) values('0', 'https://plovo.s3.ap-northeast-2.amazonaws.com/mountain/%EB%8F%84%EB%8D%95%EC%82%B0.png', '0', 5);