import { Card, CardBody, CardHeader } from "@heroui/card";
import { Chip } from "@heroui/react";

function MarathonCard({title, startDate, duration, runCount} : {title: String, startDate: String, duration: String, runCount: number}) {

    return (
        <Card isPressable isBlurred className="w-[300px] max-w-[300px]">
            <CardHeader className="justify-between">
                <h2>{title}</h2>
                <Chip className="min-w-[50px]">
                    {runCount}
                </Chip>
            </CardHeader>
            <CardBody>
                <h3 className="text-sm">{startDate}</h3>
                <h3 className="text-sm">{duration}</h3>
            </CardBody>
        </Card>
    )
}

export default MarathonCard;