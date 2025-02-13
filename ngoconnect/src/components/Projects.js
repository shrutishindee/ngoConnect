import React from "react";
import "../css/Projects.css";

const Projects = () => {
  return (
    <div className="projects-container">
      <h1 className="projects-title">Our Projects</h1>
      <div className="projects-list">
        <div className="project-item">
          <h3>Project 1</h3>
          <p>
            Project description goes here. We work on various initiatives to
            make a difference in the community.
          </p>
        </div>
        <div className="project-item">
          <h3>Project 2</h3>
          <p>
            Another project description. This one focuses on education and
            providing resources to underserved areas.
          </p>
        </div>
        <div className="project-item">
          <h3>Project 3</h3>
          <p>
            A third project focused on environmental sustainability and creating
            awareness about climate change.
          </p>
        </div>
      </div>
    </div>
  );
};

export default Projects;
