import { Swiper, SwiperSlide } from 'swiper/react'
import './Slider.css'
import desktopSlider from '../assets/slider-desktop.jpg';
import mobileSlider from '../assets/slider-mobile.jpg';

function Slider(){
    return(
        <Swiper>
            <SwiperSlide>
                <picture>
                    <source srcSet={mobileSlider} media="(max-width: 768px)" />
                    <img src={desktopSlider} alt="Banner" className="slider-image" />
                </picture>
            </SwiperSlide>
        </Swiper>
    )
}

export default Slider