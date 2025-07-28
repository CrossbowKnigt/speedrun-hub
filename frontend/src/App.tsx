import { useEffect, useState } from "react"
import MarathonCard from "./components/MarathonCard.tsx"
import type { Marathon } from "./types/Marathon.ts";
import { apiClient, getMarathons } from "./api/api.ts";


function App() {
  const [marathons, setMarathons] = useState<Marathon[]>([]);

  useEffect(() => {
    fetchData()
  }, []);

  const fetchData = async () => {
    try {
      const response = await getMarathons();
      console.log(response)
      setMarathons(response);
    } catch (error) {
      console.error('Error fetching data:', error);
      // Handle errors
    }
  };

  return (
    <>
      {marathons.map(marathon => {
        return <MarathonCard
          key={marathon.id}
          title={marathon.name}
          startDate={marathon.startDate}
          duration={marathon.endDate}
          runCount={4}
        ></MarathonCard>
      })}
    </>
  )
}

export default App
