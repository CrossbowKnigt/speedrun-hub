import { Form, Input, DatePicker, Textarea, Button, Link } from "@heroui/react";
import { createMarathon } from "../api/api";
import { type MarathonPost } from "../types/MarathonPost";

export default function MarathonForm() {


    const backText = "< Back"

    const onSubmit = (e: { preventDefault: () => void; currentTarget: HTMLFormElement | undefined; }) => {
        e.preventDefault();

        const formData = new FormData(e.currentTarget);

        const data: MarathonPost = {
            name: formData.get('name') as string,
            slug: formData.get("slug") as string,
            description: formData.get("description") as string,
            startDate: formData.get("startDate") as string
        }

        createMarathon(data)
    };

    return (
        <div className="p-3">
            <Button as={Link} href=".">{backText}</Button>
            <Form className="items-center mt-10" onSubmit={onSubmit}>
                <div className="flex flex-col min-w-[300px] gap-4">
                    <Input
                        isRequired
                        label="Marathon Name"
                        labelPlacement="outside"
                        name="name"
                        placeholder="Marathon Name"
                    >
                    </Input>
                    <Input
                        isRequired
                        label="Slug"
                        labelPlacement="outside"
                        name="slug"
                        placeholder="marathon-slug"
                    >
                    </Input>
                    <DatePicker
                        isRequired
                        label="Start Date"
                        labelPlacement="outside"
                        name="startDate"
                    />
                    <Textarea
                        label="Description"
                        labelPlacement="outside"
                        name="description"
                        placeholder="Enter your description" />
                </div>
                <div className="flex gap-3 mt-2">
                    <Button type="submit">Create</Button>
                    <Button type="reset">Reset</Button>
                </div>
            </Form>
        </div>
    )
}