import React from "react";
import Slider from "react-slick";
import "../css/Home.css";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

const Home = () => {
  const settings = {
    dots: true,
    infinite: true,
    speed: 1000,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3000,
    arrows: true,
    pauseOnHover: false,
  };

  // Use absolute paths for public/assets images
  const images = [
    "/assets/ngo1.jpg",
    "/assets/ngo2.jpg",
    "/assets/ngo3.jpg",
    "/assets/ngo4.jpg",
  ];

  return (
    <div className="home-container">
      <h1 className="home-title">Welcome to Our NGO</h1>
      <p className="home-description">
        Join us to make a difference in the community. Support our projects and
        help those in need.
      </p>

      <div className="slider-container">
        <Slider {...settings}>
          {images.map((image, index) => (
            <div key={index} className="slide">
              <img
                src={image}
                alt={`NGO ${index + 1}`}
                className="slide-image"
              />
            </div>
          ))}
        </Slider>
      </div>
    </div>
  );
};

export default Home;
