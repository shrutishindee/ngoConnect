import React, { useState, useEffect } from "react";
import { getAllProjects } from "../services/projectService";
import "../css/ProjectList.css";

const ProjectList = () => {
  const [projects, setProjects] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchProjects = async () => {
      try {
        const projectData = await getAllProjects();
        setProjects(projectData);
        setLoading(false);
      } catch (error) {
        setError("Failed to load projects");
        setLoading(false);
      }
    };

    fetchProjects();
  }, []);

  if (loading) {
    return <div className="empty-state">Loading...</div>;
  }

  if (error) {
    return <div className="empty-state">{error}</div>;
  }

  return (
    <div className="project-list-container">
      <h1>Projects</h1>
      {projects.length === 0 ? (
        <div className="empty-state">No projects available</div>
      ) : (
        <ul>
          {projects.map((project) => (
            <li key={project.projectId} className="project-item">
              <h2>{project.projectName}</h2>
              <p>{project.projectDescription}</p>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default ProjectList;
