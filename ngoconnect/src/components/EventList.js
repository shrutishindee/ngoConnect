import React, { useState, useEffect } from "react";
import { getAllEvents } from "../services/eventService";
import "../css/EventList.css";

const EventList = () => {
  const [events, setEvents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchEvents = async () => {
      try {
        const eventData = await getAllEvents();
        setEvents(eventData);
        setLoading(false);
      } catch (error) {
        setError("Failed to load events");
        setLoading(false);
      }
    };

    fetchEvents();
  }, []);

  if (loading) {
    return <div className="empty-state">Loading...</div>;
  }

  if (error) {
    return <div className="empty-state">{error}</div>;
  }

  return (
    <div className="event-list-container">
      <h1>Events</h1>
      {events.length === 0 ? (
        <div className="empty-state">No events available</div>
      ) : (
        <ul>
          {events.map((event) => (
            <li key={event.eventId} className="event-item">
              <h2>{event.eventName}</h2>
              <p>{event.eventDescription}</p>
              <p>
                <strong>Date:</strong> {event.eventDate}
              </p>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default EventList;
