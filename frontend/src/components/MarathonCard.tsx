import { Card, CardBody, CardHeader } from "@heroui/card";

function MarathonCard({ title, startDate, duration }: { title: String, startDate: String, duration: String }) {

    return (
        <Card isPressable isBlurred>
            <CardHeader className="justify-between gap-3">
                <h2 className="overflow-hidden text-ellipsis">{title}</h2>
                {/* <Chip className="min-w-[50px]">
                    {runCount}
                </Chip> */}
            </CardHeader>
            <CardBody>
                <h3 className="text-sm">{startDate}</h3>
                <h3 className="text-sm">{duration}</h3>
            </CardBody>
        </Card>
    )
}

export default MarathonCard;