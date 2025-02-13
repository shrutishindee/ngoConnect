import React from "react";
import "../css/AboutUs.css";
import { motion } from "framer-motion";

const AboutUs = () => {
  return (
    <div className="aboutus-container">
      {/* Banner Section */}
      <div className="banner">
        <img
          src="/assets/about-banner.jpg"
          alt="About Us"
          className="banner-image"
        />
        <h1 className="banner-title">About Us</h1>
      </div>

      {/* Overview Section */}
      <section className="section">
        <h2 className="section-title">Overview</h2>
        <p className="section-description">
          We are a non-profit organization committed to making a positive impact
          on communities. Our mission is to empower individuals, provide
          resources, and create a better world.
        </p>
      </section>

      {/* Mission Section */}
      <section className="section side-by-side">
        <motion.div
          className="image-container"
          initial={{ opacity: 0, scale: 0.8 }}
          animate={{ opacity: 1, scale: 1 }}
          transition={{ duration: 1 }}
        >
          <img
            src="/assets/mission.jpg"
            alt="Mission"
            className="section-image"
          />
        </motion.div>
        <div className="text-container">
          <h2 className="section-title">Our Mission</h2>
          <p className="section-description">
            To uplift underprivileged communities by providing education,
            healthcare, and sustainable resources.
          </p>
        </div>
      </section>

      {/* Vision Section */}
      <section className="section side-by-side">
        <div className="text-container">
          <h2 className="section-title">Our Vision</h2>
          <p className="section-description">
            A world where every individual has access to basic human needs and
            opportunities to thrive.
          </p>
        </div>
        <motion.div
          className="image-container"
          initial={{ opacity: 0, scale: 0.8 }}
          animate={{ opacity: 1, scale: 1 }}
          transition={{ duration: 1 }}
        >
          <img
            src="/assets/vision.jpg"
            alt="Vision"
            className="section-image"
          />
        </motion.div>
      </section>

      {/* Values Section - Side by Side */}
      <section className="section side-by-side">
        <motion.div
          className="text-container"
          initial={{ opacity: 0, x: -50 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ duration: 1 }}
        >
          <h2 className="section-title">Our Core Values</h2>
          <ul className="values-list">
            <li>Compassion</li>
            <li>Integrity</li>
            <li>Transparency</li>
            <li>Collaboration</li>
            <li>Innovation</li>
          </ul>
        </motion.div>
        <motion.img
          src="/assets/values.jpg"
          alt="Values"
          className="section-image"
          initial={{ opacity: 0, x: 50 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ duration: 1 }}
        />
      </section>

      {/* Goals Section - Side by Side */}
      <section className="section side-by-side">
        <motion.img
          src="/assets/goals.jpg"
          alt="Goals"
          className="section-image"
          initial={{ opacity: 0, x: -50 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ duration: 1 }}
        />
        <motion.div
          className="text-container"
          initial={{ opacity: 0, x: 50 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ duration: 1 }}
        >
          <h2 className="section-title">Our Goals</h2>
          <ul className="goal-list">
            <li>
              ✅ Provide education to 10,000 children in underserved areas
            </li>
            <li>✅ Improve healthcare access for 50,000 individuals</li>
            <li>✅ Launch 20 sustainable development projects</li>
          </ul>
        </motion.div>
      </section>

      {/* Milestones Section - Side by Side */}
      <section className="section side-by-side">
        <motion.div
          className="text-container"
          initial={{ opacity: 0, x: -50 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ duration: 1 }}
        >
          <h2 className="section-title">Key Milestones</h2>
          <ul className="milestone-list">
            <li>🎉 2015: NGO Founded</li>
            <li>🎉 2018: First 1000 children educated</li>
            <li>🎉 2021: Expanded to 5 new countries</li>
          </ul>
        </motion.div>
        <motion.img
          src="/assets/milestones.jpg"
          alt="Milestones"
          className="section-image"
          initial={{ opacity: 0, x: 50 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ duration: 1 }}
        />
      </section>

      {/* Awards Section - Side by Side */}
      <section className="section side-by-side">
        <motion.img
          src="/assets/awards.jpg"
          alt="Awards"
          className="section-image"
          initial={{ opacity: 0, x: -50 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ duration: 1 }}
        />
        <motion.div
          className="text-container"
          initial={{ opacity: 0, x: 50 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ duration: 1 }}
        >
          <h2 className="section-title">Awards & Recognition</h2>
          <ul className="awards-list">
            <li>🏆 Best Humanitarian NGO - 2022</li>
            <li>🏆 Excellence in Social Work - 2023</li>
          </ul>
        </motion.div>
      </section>
    </div>
  );
};

export default AboutUs;
