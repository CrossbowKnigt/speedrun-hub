import { useEffect, useState } from "react";
import type { Marathon } from "../types/Marathon";
import { getMarathons } from "../api/api";
import MarathonCard from "../components/MarathonCard";
import { Button, Link } from "@heroui/react";
import PlusIcon from "../components/PlusIcon";



export default function MarathonPage() {

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
            <div className="w-full p-4 flex justify-between items-center">
                <h1>My Marathons</h1>
                <Button as={Link}  href="/marathons/new" startContent={<PlusIcon/>}>New Marathon</Button>
            </div>
            <div className="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-5 gap-2 p-3">
                {marathons.map(marathon => {
                    return <MarathonCard
                        key={marathon.id}
                        title={marathon.name}
                        startDate={marathon.startDate}
                        duration={marathon.endDate}
                    // runCount={4}
                    ></MarathonCard>
                })}
            </div>
        </>
    )
}