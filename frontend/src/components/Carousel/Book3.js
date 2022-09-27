import React, { useRef, useCallback, useState } from 'react';
import 'tailwindcss/tailwind.css';
// Import Swiper React components
import { Swiper, SwiperSlide } from 'swiper/react';
import { Navigation, Pagination } from 'swiper';
import './carousel.css';
import './pagination.css';
import './3.css';

import 'swiper/css/navigation';
const BookCarousel = () => {
  const More = useRef(null);
  const [more, setMore] = useState(false);

  const onMouseOver = useCallback(() => {
    setMore(!more);
  });

  const onMouseOut = useCallback(() => {
    setMore(!more);
  });

  return (
    <div className=" px-[5%] pt-10">
      <div className="rowTitle">
        <div
          el={More}
          onMouseOver={onMouseOver}
          onMouseOut={onMouseOut}
          className="text-[1.4vw] font-bold"
        >
          제목
        </div>

        <div className="see-all-link" style={{ padding: '0.9vw 0px 0px .4vw' }}>
          <a href={{}}>모두 보기</a>
        </div>
        <div
          className={`aro-row-chevron z-30
        ${more ? 'translate-x-[950%] duration-100' : ''}
        `}
          style={{ padding: '0.9vw 0px 0px 0vw' }}
        >
          ❯
        </div>
      </div>

      <Swiper
        spaceBetween={10}
        slidesPerView={7}
        slidesPerGroup={7}
        onSlideChange={() => console.log('slide change')}
        onSwiper={(swiper) => console.log(swiper)}
        navigation={true}
        pagination={true}
        modules={[Navigation, Pagination]}
        loop={true}
        speed={600}
        // width={1100}
      >
        <SwiperSlide className="bb w-60 h-[20.5rem] items-center flex justify-center hover:bg-sky-700 hover:scale-125 duration-300 origin-left hover:z-50">
          <img src="https://img.ridicdn.net/cover/4621001638/xxlarge#1"></img>
        </SwiperSlide>
        <SwiperSlide className="bb w-60 h-[20.5rem] items-center flex justify-center hover:bg-sky-700 hover:scale-125 duration-300 hover:z-50">
          <img src="https://img.ridicdn.net/cover/1377099102/xxlarge#1"></img>
        </SwiperSlide>
        <SwiperSlide className="bb w-60 h-[20.5rem] items-center flex justify-center hover:bg-sky-700 hover:scale-125 duration-300 hover:z-50">
          <img src="https://img.ridicdn.net/cover/3092017733/xxlarge#1"></img>
        </SwiperSlide>
        <SwiperSlide className="bb w-60 h-[20.5rem] items-center flex justify-center hover:bg-sky-700 hover:scale-125 duration-300 hover:z-50">
          <img src="https://img.ridicdn.net/cover/1811203363/xxlarge#1"></img>
        </SwiperSlide>
        <SwiperSlide className="bb w-60 h-[20.5rem] items-center flex justify-center hover:bg-sky-700 hover:scale-125 duration-300 hover:z-50">
          <img src="https://img.ridicdn.net/cover/2259009524/xxlarge#1"></img>
        </SwiperSlide>
        <SwiperSlide className="bb w-60 h-[20.5rem] items-center flex justify-center hover:bg-sky-700 hover:scale-125 duration-300 hover:z-50">
          <img src="https://via.placeholder.com/485x670"></img>
        </SwiperSlide>
        <SwiperSlide className="bb w-60 h-[20.5rem] items-center flex justify-center hover:bg-sky-700 hover:scale-125 duration-300 origin-right hover:z-50">
          <img src="https://via.placeholder.com/480x670"></img>
        </SwiperSlide>
        <SwiperSlide className="bb w-60 h-[20.5rem] items-center flex justify-center hover:bg-sky-700 hover:scale-125 duration-300 origin-left hover:z-50">
          <img src="https://img.ridicdn.net/cover/425306513/xxlarge#1"></img>
        </SwiperSlide>
        <SwiperSlide className="bb w-60 h-[20.5rem] items-center flex justify-center hover:bg-sky-700 hover:scale-125 duration-300 hover:z-50">
          <img src="https://img.ridicdn.net/cover/2008033538/xxlarge#1"></img>
        </SwiperSlide>
        <SwiperSlide className="bb w-60 h-[20.5rem] items-center flex justify-center hover:bg-sky-700 hover:scale-125 duration-300 hover:z-50">
          <img src="https://img.ridicdn.net/cover/2065072847/xxlarge#1"></img>
        </SwiperSlide>
        <SwiperSlide className="bb w-60 h-[20.5rem] items-center flex justify-center hover:bg-sky-700 hover:scale-125 duration-300 hover:z-50">
          <img src="https://img.ridicdn.net/cover/3076030032/xxlarge#1"></img>
        </SwiperSlide>
        <SwiperSlide className="bb w-60 h-[20.5rem] items-center flex justify-center hover:bg-sky-700 hover:scale-125 duration-300 hover:z-50">
          <img src="https://img.ridicdn.net/cover/2065072847/xxlarge#1"></img>
        </SwiperSlide>
        <SwiperSlide className="bb w-60 h-[20.5rem] items-center flex justify-center hover:bg-sky-700 hover:scale-125 duration-300 hover:z-50">
          <img src="https://img.ridicdn.net/cover/3076030032/xxlarge#1"></img>
        </SwiperSlide>
        <SwiperSlide className="bb w-60 h-[20.5rem] items-center flex justify-center hover:bg-sky-700 hover:scale-125 duration-300 origin-right hover:z-50">
          <img src="https://img.ridicdn.net/cover/425297966/xxlarge#1"></img>
        </SwiperSlide>
        <div className="swiper-left-cover"></div>
        <div className="swiper-right-cover"></div>
      </Swiper>
    </div>
  );
};

export default BookCarousel;